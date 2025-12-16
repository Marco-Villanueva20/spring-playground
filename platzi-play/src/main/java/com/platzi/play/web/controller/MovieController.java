package com.platzi.play.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.dto.SuggestRequestDto;
import com.platzi.play.domain.dto.UpdateMovieDto;
import com.platzi.play.domain.service.MovieService;
import com.platzi.play.domain.service.PlayAiService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController()
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService; 
    private final PlayAiService aiService;
    
    public MovieController(MovieService movieService,
    PlayAiService aiService) {
        this.movieService = movieService;
        this.aiService = aiService;
    }

    @GetMapping()
    public ResponseEntity<List<MovieDto>> getMovieEntity() {
        return ResponseEntity.ok(movieService.getAll());
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieEntityById(@PathVariable Long id){
        MovieDto movieDto = movieService.getById(id);
        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @PostMapping()
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(entity));
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @RequestBody UpdateMovieDto entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.update(id,entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/suggest")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto){
       String response = this.aiService.generateMoviesSuggestion(suggestRequestDto.userPreferences()); 
        return ResponseEntity.ok(response);

    }
    

}
