package com.example.todolist.controllers;

import com.example.todolist.dto.TareaCategorias;
import com.example.todolist.dto.TareaJoin;
import com.example.todolist.entitys.*;
import com.example.todolist.repository.CategoriaRepository;
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
    private CategoriaRepository categoriaRepository;

    @GetMapping("/tareas")
    public List<Tarea> getAllTarea(){
        return (List<Tarea>) tareaRepository.findAll();
    }

    @PostMapping("/tarea")
    public void addTarea(@RequestBody TareaCategorias tareaCategorias){
        for(Categoria c: tareaCategorias.getCategorias()){
            c.addTarea(tareaCategorias.getTarea());
            categoriaRepository.save(c);
        }
    }

    @DeleteMapping("/tarea/{id}")
    public void deleteTarea(@PathVariable Integer id ){
         tareaRepository.deleteById(id);
    }

    @GetMapping("/agregarTareaACategoria")
    public Categoria sad(){
        Categoria c = categoriaRepository.getById(1);
        Tarea tarea = new Tarea();
        tarea.setTarea("tarea java");
        c.addTarea(tarea);
        categoriaRepository.save(c);

        for(Tarea t: c.getTareas()){
            for(Categoria categoriaa : t.getCategorias()){
                categoriaa.setCategoria(null);
            }
        }

        return c;
    }

//    @GetMapping("/tareasCategoria")
//    public List<TareaJoin> getTareasDeCategoria(@RequestBody Categoria categoria){
//        return tareaRepository.getJoinInformation(categoria);
//    }

}
