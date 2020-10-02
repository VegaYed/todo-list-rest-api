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

    /**
     *
     *
     * @return Categoria
     *
     */
    @PostMapping("/categoria")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        try{
            return new ResponseEntity<>(categoriaRepository.save(categoria), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Retorna una lista de categorias
     * @return List<Categoria>
     *
     */
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> buscarTodas(){
        try{
            return new ResponseEntity<>(categoriaRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    /**
     *
     *
     * @return String
     */
    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable int id){
        try{
            categoriaRepository.deleteById(id);
            return new ResponseEntity<>("Eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     * Retorna todas las tareas de una categoria en forma de lista
     *
     *
     * @return List<Tarea>
     */
    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Tarea>> buscarCategoria(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(tareaRepository.nativeQuery(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
