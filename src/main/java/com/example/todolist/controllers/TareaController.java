package com.example.todolist.controllers;

import com.example.todolist.dto.TareaCategorias;
import com.example.todolist.entities.Categoria;
import com.example.todolist.entities.CategoriaTareas;
import com.example.todolist.entities.Tarea;
import com.example.todolist.repository.CategoriaTareasRepository;
import com.example.todolist.repository.TareaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/")
public class TareaController {

    /**
     * 
     * Give the Entity Repository to manage CRUD operations
     */
    @Autowired
    private TareaRepository tareaRepository;

    /**
     * 
     * Give the Entity Repository to manage CRUD operations
     */
    @Autowired
    private CategoriaTareasRepository categoriaTareasRepository;

    
    /**
     * 
     * Return all tasks from the database
     */
    @GetMapping("/tareas")
    public List<Tarea> obtenerTareas(){
        return tareaRepository.findAll();
    }

    @PostMapping("/tarea")
    public Tarea crearTarea(@RequestBody TareaCategorias tareaCategorias){
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
    public void eliminarTarea(@PathVariable Integer id){
        tareaRepository.deleteById(id);
    }

    @PutMapping("/tarea")
    public Tarea actualizarTarea(@RequestBody Tarea tarea){
        return tareaRepository.save(tarea);
    }





}
