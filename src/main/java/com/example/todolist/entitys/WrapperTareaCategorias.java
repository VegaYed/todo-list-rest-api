package com.example.todolist.entitys;

import lombok.Data;

@Data
public class WrapperTareaCategorias {

    private Tarea tarea;
    private Categoria[] categorias;

}
