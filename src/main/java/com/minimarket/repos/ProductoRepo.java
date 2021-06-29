package com.minimarket.repos;

import com.minimarket.models.Categoria;
import com.minimarket.models.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepo extends CrudRepository<Producto, Long> {

    //SELECCIONAR TODAS LAS CATEGORÍAS
    @Query("FROM Categoria")
    public List<Categoria> findCategorias();

    //SELECCIONAR TODOS LOS PRODUCTOS CON EL ID_CATEGORÍA QUE VENGA DE PARÁMETRO(LONG id)
    @Query("FROM Producto p WHERE p.categoria.id = ?1")
    public List<Producto> getProductosPorCate(Long id);

    //BUSCAR PRODUCTOS POR NOMBRE
    public List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
