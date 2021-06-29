package com.minimarket.services;

import com.minimarket.models.Categoria;
import com.minimarket.models.Producto;

import java.util.List;

public interface ProductoService {

    public Producto crearProducto(Producto producto);

    public Producto findById(Long id);

    public List<Producto> findAll();

    public List<Categoria> findCategorias();

    public boolean eliminarProducto(Long id);

    public List<Producto> getProductosPorCate(Long id);

    public List<Producto> findByNombreLike(String nombre);

}
