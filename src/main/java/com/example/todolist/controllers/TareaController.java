package com.example.todolist.controllers;

import com.example.todolist.entitys.Categoria;
import com.example.todolist.entitys.Tarea;
import com.example.todolist.entitys.TareaCategoria;
import com.example.todolist.entitys.TareaCompleta;
import com.example.todolist.repository.TareaCategoriaRepository;
import com.example.todolist.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class TareaController {

    @Autowired
    TareaRepository tareaRepository;

    @Autowired
    TareaCategoriaRepository tareaCategoriaRepository;

//    @PostMapping("/tarea")
//    public void crearTarea(@RequestBody Tarea tarea, @RequestBody int[] categorias){
//        crearTareaCategoria(categorias, tareaRepository.save(tarea).getId());
//    }

    @PostMapping("/tarea")
    public void crearTarea(@RequestBody TareaCompleta tareaCompleta){
        tareaRepository.save(tareaCompleta.getTarea());
        if(tareaCompleta.getCategorias() !=null){
            crearTareaCategoria(tareaCompleta.getCategorias(), tareaCompleta.getTarea().getId());
        }
    }

    private void crearTareaCategoria(int[] categorias, int idTarea){
        for (int categoria : categorias) {
            TareaCategoria c = new TareaCategoria();
            c.setCategoria(categoria);
            c.setTarea(idTarea);
            tareaCategoriaRepository.save(c);
        }
    }



}
