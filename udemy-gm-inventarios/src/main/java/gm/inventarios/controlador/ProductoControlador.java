package gm.inventarios.controlador;

import gm.inventarios.entity.Producto;
import gm.inventarios.service.ProductoServicio;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("api/v1/productos")
public class ProductoControlador {

    private final ProductoServicio productoServicio;
    private final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {


        return ResponseEntity.ok(productoServicio.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Long id) {
        return ResponseEntity.ok(productoServicio.buscarProductoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto request, UriComponentsBuilder ucb) {

        Producto producto = productoServicio.guardarProducto(request);

        URI location = ucb
                .path("api/v1/productos/{id}")
                .buildAndExpand(producto.getIdProducto())
                .toUri();

        return ResponseEntity.created(location).body(producto);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto request
    ) {
        request.setIdProducto(id);
        Producto actualizado = productoServicio.actualizarProducto(id, request);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        //return ResponseEntity.ok(actualizado);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{requestId}")
    public ResponseEntity<Void> eliminarProductoPorId(@PathVariable Long requestId) {
        if (productoServicio.existePorId(requestId)) {
            productoServicio.eliminarProductoPorId(requestId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
