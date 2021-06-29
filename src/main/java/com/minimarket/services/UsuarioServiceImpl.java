package com.minimarket.services;

import com.minimarket.models.Usuario;
import com.minimarket.repos.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario findByUsernameAndPassowrd(String username, String password) {
        return usuarioRepo.findByUsernameAndPassword(username,password);
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepo.findByUsername(username);
    }

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepo.findAll();
    }
}
