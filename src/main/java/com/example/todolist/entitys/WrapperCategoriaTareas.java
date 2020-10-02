package com.example.todolist.entitys;

import lombok.Data;

@Data
public class WrapperCategoriaTareas {

    private Categoria categoria;
    private Tarea[] tareas;

}
