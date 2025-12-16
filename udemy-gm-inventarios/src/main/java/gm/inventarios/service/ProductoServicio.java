package gm.inventarios.service;

import gm.inventarios.entity.Producto;
import gm.inventarios.repositorio.ProductoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServicio implements IProductoServicio {
    private final ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> listarProductos() {
        return productoRepositorio.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Long idProducto) {
        return productoRepositorio.findById(idProducto).orElse(null);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
       return productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProductoPorId(Long idProducto) {
        productoRepositorio.deleteById(idProducto);
    }

    @Override
    public boolean existePorId(Long idProducto) {
       return productoRepositorio.existsById(idProducto);
    }

    @Override
    public Producto actualizarProducto(Long id, Producto request) {
        Producto actual = buscarProductoPorId(id);
        if (actual == null) return null;

        actual.setDescripcion(request.getDescripcion());
        actual.setPrecio(request.getPrecio());
        actual.setExistencia(request.getExistencia());

        return productoRepositorio.save(actual);
    }

}
