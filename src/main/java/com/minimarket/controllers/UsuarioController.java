package com.minimarket.controllers;

import com.minimarket.models.Usuario;
import com.minimarket.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAllUsuarios(){
        return new ResponseEntity<List<Usuario>>(usuarioService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<Usuario> login(@RequestParam("username") String username, @RequestParam("password") String password){
        return new ResponseEntity<Usuario>(usuarioService.findByUsernameAndPassowrd(username, password), HttpStatus.OK);
    }

    @GetMapping("/buscarUsuario")
    public ResponseEntity<Usuario> buscarUsuario(@RequestParam("username") String username){
        return new ResponseEntity<Usuario>(usuarioService.findByUsername(username), HttpStatus.OK);
    }
}
