package com.example.todolist.utlidades;

import com.example.todolist.entitys.Categoria;
import com.example.todolist.entitys.Tarea;
import com.example.todolist.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TareasDeCategoria {

    public static Categoria filtrarTareas(Categoria categoria){
        for(Tarea t: categoria.getTareas()){
            for(Categoria categoriaa : t.getCategorias()){
                categoriaa.setCategoria(null);
            }
        }
        return categoria;
    }


}
