package com.example.todolist.controllers;

import com.example.todolist.entitys.Categoria;
import com.example.todolist.entitys.Tarea;
import com.example.todolist.repository.CategoriaRepository;
import com.example.todolist.utlidades.TareasDeCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @CrossOrigin
    @PostMapping("/categoria")
    public Categoria crearCategoria(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @CrossOrigin
    @GetMapping("/categorias")
    public List<Categoria> buscaTodas(){
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @CrossOrigin
    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable int id){
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/categoria/{id}")
    public Categoria getOne(@PathVariable Integer id){
//        Optional<Categoria> categoria = categoriaRepository.findById(id);
//        return categoria.map(TareasDeCategoria::filtrarTareas).get();
        return TareasDeCategoria.filtrarTareas(categoriaRepository.getById(id));

    }




}
