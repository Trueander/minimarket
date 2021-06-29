package com.minimarket.services;

import com.minimarket.models.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario crearUsuario(Usuario usuario);

    public Usuario findByUsernameAndPassowrd(String username, String password);

    public Usuario findByUsername(String username);

    public List<Usuario> findAll();
}
