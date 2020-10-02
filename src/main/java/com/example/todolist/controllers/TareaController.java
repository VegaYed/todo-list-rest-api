package com.example.todolist.controllers;

import com.example.todolist.dto.TareaCategorias;
import com.example.todolist.dto.TareaJoin;
import com.example.todolist.entitys.*;
import com.example.todolist.repository.CategoriaRepository;
import com.example.todolist.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/tareas")
    public List<Tarea> getAllTarea(){
        return tareaRepository.findAll();
    }

    @PostMapping("/tarea")
    public Tarea addTarea(@RequestBody TareaCategorias tareaCategorias){
        return tareaRepository.save(tareaCategorias.getTarea());
    }

    @DeleteMapping("/tarea/{id}")
    public void deleteTarea(@PathVariable Integer id){
        tareaRepository.deleteById(id);
    }

    @PutMapping("/tarea")
    public Tarea updateTarea(@RequestBody Tarea tarea){
        return tareaRepository.save(tarea);
    }




}
