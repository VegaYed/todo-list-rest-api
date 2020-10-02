package com.example.todolist.controllers;

import com.example.todolist.entities.Categoria;
import com.example.todolist.entities.Tarea;
import com.example.todolist.repository.CategoriaRepository;
import com.example.todolist.repository.TareaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class CategoriaController {

    /**
     * 
     * Give the Entity Repository to manage CRUD operations
     */
    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * 
     * Give the Entity Repository to manage CRUD operations
     */
    @Autowired
    private TareaRepository tareaRepository;

    @PostMapping("/categoria")
    public Categoria crearCategoria(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/categorias")
    public List<Categoria> buscarTodas(){
        return categoriaRepository.findAll();
    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable int id){
        categoriaRepository.deleteById(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }

    @GetMapping("/categoria/{id}")
    public List<Tarea> buscarCategoria(@PathVariable Integer id){
        return tareaRepository.nativeQuery(id);
    }
}
