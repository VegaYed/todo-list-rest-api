package com.example.todolist.repository;

import com.example.todolist.dto.TareaJoin;
import com.example.todolist.entitys.Categoria;
import com.example.todolist.entitys.Tarea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TareaRepository extends CrudRepository<Tarea, Integer>{

//    @Query("SELECT new com.example.todolist.dto.TareaJoin(t.tarea, t.fechaRealizacion) FROM Tarea t INNER JOIN CategoriaTarea " +
//            "c ON t.idtarea = c.idTarea WHERE c.idCategoria = :#{categoria.tareas.}")
//    List<TareaJoin> getJoinInformation(@Param("categoria")Categoria categoria);

}