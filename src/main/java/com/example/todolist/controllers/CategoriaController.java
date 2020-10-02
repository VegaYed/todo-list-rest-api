package com.example.todolist.controllers;

import com.example.todolist.dto.CategoriaTareas2;
import com.example.todolist.entitys.Categoria;
import com.example.todolist.entitys.CategoriaTareas;
import com.example.todolist.entitys.Tarea;
import com.example.todolist.repository.CategoriaRepository;
import com.example.todolist.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    private TareaRepository tareaRepository;

    @PostMapping("/categoria")
    public Categoria crearCategoria(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @GetMapping("/categorias")
    public List<Categoria> buscaTodas(){
        return categoriaRepository.findAll();
    }

    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable int id){
        categoriaRepository.deleteById(id);
        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }

    @GetMapping("/categoria/{id}")
    public List<Tarea> getOne(@PathVariable Integer id){
        return tareaRepository.nativeQuery(id);
    }


    @GetMapping("/ppql")
    public List<CategoriaTareas2> picoPalQueLee(){
        List<CategoriaTareas2> categoriaTareasList = new ArrayList<>();
        for(Categoria categoria: categoriaRepository.findAll()){
            CategoriaTareas2 ct2 = new CategoriaTareas2();
            ct2.setCategoria(categoria);
            categoriaTareasList.add(ct2);
            for (Tarea t: tareaRepository.nativeQuery(categoria.getId())){
                System.out.println(t);
            }
        }
        return categoriaTareasList;
    }

}
