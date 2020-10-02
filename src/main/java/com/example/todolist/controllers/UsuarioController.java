package com.example.todolist.controllers;

import com.example.todolist.entitys.Usuario;
import com.example.todolist.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        String user = usuario.getNombre();
        String password =  usuario.getPassword();
        if(repository.findByNombreAndPassword(user,password) != null){
            return "token";
        }
        return null;
    }

    @PostMapping("/user")
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }



}
