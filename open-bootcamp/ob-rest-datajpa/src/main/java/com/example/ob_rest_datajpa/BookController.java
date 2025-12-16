package com.example.ob_rest_datajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


/**
 * @author Marco Villanueva
 *
 */
@RestController
@RequestMapping("api/v1/books")
public class BookController {

    //atributo
    private final BookRepository bookRepository;

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    //constructor
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody Book request, UriComponentsBuilder ucb) {

        Book book = bookRepository.save(request);
        URI locationToNewBook = ucb.path("api/v1/books/{id}")
                .buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(locationToNewBook).build();
    }

    /**
     * http://localhost:8081/api/v1/books
     *
     * @return Listado de libros
     */
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookRepository.findAll());
    }

    /**
     * http://localhost:8081/api/v1/books/1
     *
     * @param id es el id del book
     * @return Listado de libros
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> finOneById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        //opcion 2
        //return ResponseEntity.ok(bookOpt.orElse(null));
    }

    /**
     * @param id el parametro que sera buscado en adelante
     * @param request el request que sera actualizado
     * */
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@RequestBody Book request, @PathVariable Long id){
        if (!bookRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }else {
            request.setId(id);
            Book bookUpdate = bookRepository.save(request);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
