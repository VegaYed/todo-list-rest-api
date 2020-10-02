package com.example.todolist.dto;

import com.example.todolist.entitys.Categoria;
import com.example.todolist.entitys.Tarea;
import lombok.Data;

import java.util.List;

@Data
public class CategoriaTareas2 {

    private Categoria categoria;
    private List<Tarea> tareas;

    public void addTarea(Tarea tarea){
        this.tareas.add(tarea);
    }

}
