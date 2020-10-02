package com.example.todolist.controllers;

import com.example.todolist.dto.TareaCategorias;
import com.example.todolist.entities.Categoria;
import com.example.todolist.entities.CategoriaTareas;
import com.example.todolist.entities.Tarea;
import com.example.todolist.repository.CategoriaTareasRepository;
import com.example.todolist.repository.TareaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Tarea>> obtenerTareas(){
        try{
            return new ResponseEntity<>(tareaRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/tarea")
    public ResponseEntity<Tarea> crearTarea(@RequestBody TareaCategorias tareaCategorias){
        try{
            Tarea tarea = tareaRepository.save(tareaCategorias.getTarea());
            for(Categoria categoria: tareaCategorias.getCategorias()){
                CategoriaTareas ct = new CategoriaTareas();
                ct.setId_tarea(tarea.getIdtarea());
                ct.setId_categoria(categoria.getId());
                categoriaTareasRepository.save(ct);
                System.out.println(ct);
            }
            return new ResponseEntity<>(tarea,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }


    }

    @DeleteMapping("/tarea/{id}")
    public ResponseEntity<String> eliminarTarea(@PathVariable Integer id){
        try{
            tareaRepository.deleteById(id);
            return new ResponseEntity<>("Eliminado", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error al eliminar", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/tarea")
    public ResponseEntity<Tarea> actualizarTarea(@RequestBody Tarea tarea){
        try{
            return new ResponseEntity<>(tareaRepository.save(tarea), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }





}
