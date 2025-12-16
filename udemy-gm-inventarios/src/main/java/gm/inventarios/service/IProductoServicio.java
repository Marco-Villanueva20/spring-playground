package gm.inventarios.service;

import gm.inventarios.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoServicio {
    public List<Producto> listarProductos();
    public Producto buscarProductoPorId(Long idProducto);
    public Producto guardarProducto(Producto producto);
    public void eliminarProductoPorId(Long idProducto);
    boolean existePorId(Long idProducto);
    public Producto actualizarProducto(Long id, Producto request);
}
