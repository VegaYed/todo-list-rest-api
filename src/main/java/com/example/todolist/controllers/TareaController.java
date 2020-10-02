package com.example.todolist.controllers;

import com.example.todolist.dto.TareaCategorias;
import com.example.todolist.entitys.*;
import com.example.todolist.repository.CategoriaRepository;
import com.example.todolist.repository.CategoriaTareasRepository;
import com.example.todolist.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private CategoriaTareasRepository categoriaTareasRepository;

    @GetMapping("/tareas")
    public List<Tarea> getAllTarea(){
        return tareaRepository.findAll();
    }

    @PostMapping("/tarea")
    public Tarea addTarea(@RequestBody TareaCategorias tareaCategorias){
        Tarea tarea = tareaRepository.save(tareaCategorias.getTarea());
        for(Categoria categoria: tareaCategorias.getCategorias()){
            CategoriaTareas ct = new CategoriaTareas();
            ct.setId_tarea(tarea.getIdtarea());
            ct.setId_categoria(categoria.getId());
            categoriaTareasRepository.save(ct);
            System.out.println(ct);
        }
        return tarea;
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
