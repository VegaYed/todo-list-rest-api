package com.example.todolist.controllers;

import com.example.todolist.dto.Token;
import com.example.todolist.entities.Usuario;
import com.example.todolist.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class UsuarioController {

    /**
     * 
     * Give the Entity Repository to manage CRUD operations
     * Ijecta UsuarioRository a usuarioRepository
     */
    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * 
     * Retorna a token to the front-end if the data is equals to the database.
     * Else return null.
     */
    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Usuario usuario) {
        try{
            String user = usuario.getNombre();
            String password =  usuario.getPassword();
            Token token = new Token();
            if(usuarioRepository.findByNombreAndPassword(user,password) != null){
                token.setToken("token");
                return new ResponseEntity<>(token, HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario){
        try{
            return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
