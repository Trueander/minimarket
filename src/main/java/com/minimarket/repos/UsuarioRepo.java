package com.minimarket.repos;

import com.minimarket.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepo extends CrudRepository<Usuario, Long>{

    public Usuario findByUsernameAndPassword(String username, String password);
    public Usuario findByUsername(String username);
}
