package com.minimarket.controllers;

import com.minimarket.models.Categoria;
import com.minimarket.models.Producto;
import com.minimarket.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAllProductos(){
        return new ResponseEntity<List<Producto>>(productoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/byNombre")
    public ResponseEntity<List<Producto>> findProductosByNombre(@RequestParam("nombre") String nombre){
        return new ResponseEntity<List<Producto>>(productoService.findByNombreLike(nombre), HttpStatus.OK);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> findAllCategorias(){
        return new ResponseEntity<List<Categoria>>(productoService.findCategorias(), HttpStatus.OK);
    }
    @GetMapping("/productosCategoria")
    public ResponseEntity<List<Producto>> getProductosPorCategoria(@RequestParam("id") String id){
        return new ResponseEntity<List<Producto>>(productoService.getProductosPorCate(Long.parseLong(id)), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        return new ResponseEntity<Producto>(productoService.crearProducto(producto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Long id){
        return new ResponseEntity<Producto>(productoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminarProducto(@PathVariable Long id){
        return new ResponseEntity<Boolean>(productoService.eliminarProducto(id), HttpStatus.OK);
    }

}
