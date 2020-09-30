package com.example.todolist.controllers;

import com.example.todolist.entitys.Categoria;
import com.example.todolist.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping("/categoria")
    public Integer crearCategoria(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria).getId();
    }

    @GetMapping("/categorias")
    public List<Categoria> buscaTodas(){
        return (List<Categoria>) categoriaRepository.findAll();
    }

}
