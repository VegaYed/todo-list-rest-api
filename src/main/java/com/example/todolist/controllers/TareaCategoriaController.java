package com.example.todolist.controllers;

import com.example.todolist.entitys.TareaCategoria;
import com.example.todolist.repository.TareaCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class TareaCategoriaController {

    @Autowired
    TareaCategoriaRepository tareaCategoriaRepository;

    @GetMapping("tareas")
    private List<TareaCategoria> getAll(){
        return (List<TareaCategoria>) tareaCategoriaRepository.findAll();
    }

}
