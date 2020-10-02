package com.example.todolist.controllers;

import com.example.todolist.dto.Token;
import com.example.todolist.entities.Usuario;
import com.example.todolist.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UsuarioController {

    /**
     * 
     * Give the Entity Repository to manage CRUD operations
     */
    @Autowired
    private UsuarioRepository repository;

    /**
     * 
     * Return a token to the front-end if the data is equals to the database.
     * Else return null.
     */
    @PostMapping("/login")
    public Token login(@RequestBody Usuario usuario) {
        String user = usuario.getNombre();
        String password =  usuario.getPassword();
        Token token = new Token();
        if(repository.findByNombreAndPassword(user,password) != null){
            token.setToken("token");
            return token;
        }
        return null;
    }

    @PostMapping("/user")
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }
}
