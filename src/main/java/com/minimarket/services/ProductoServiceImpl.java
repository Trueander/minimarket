package com.minimarket.services;

import com.minimarket.models.Categoria;
import com.minimarket.models.Producto;
import com.minimarket.repos.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepo productoRepo;

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public Producto findById(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepo.findAll();
    }

    @Override
    public List<Categoria> findCategorias() {
        return productoRepo.findCategorias();
    }

    @Override
    public boolean eliminarProducto(Long id) {
        return productoRepo.findById(id)
                            .map(p -> {
                                productoRepo.deleteById(id);
                                return true;
                            }).orElse(false);
    }

    @Override
    public List<Producto> getProductosPorCate(Long id) {
        return productoRepo.getProductosPorCate(id);
    }

    @Override
    public List<Producto> findByNombreLike(String nombre) {
        return productoRepo.findByNombreContainingIgnoreCase(nombre);
    }
}
