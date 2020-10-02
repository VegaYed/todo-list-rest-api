package com.example.todolist.dto;

import com.example.todolist.entities.Categoria;
import com.example.todolist.entities.Tarea;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class TareaCategorias {

    private Tarea tarea;
    private Set<Categoria> categorias = new HashSet<>();

    public void addCategoria(Categoria categoria){
        this.categorias.add(categoria);
    }

}
