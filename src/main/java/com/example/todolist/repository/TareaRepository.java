package com.example.todolist.repository;

import com.example.todolist.entitys.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    @Query(value = "SELECT tarea.id, tarea.tarea, tarea.fecha_realizacion FROM tarea INNER JOIN categoria_tarea ON tarea.id = categoria_tarea.id_tarea WHERE categoria_tarea.id_categoria = ?1", nativeQuery = true )
    List<Tarea> nativeQuery(Integer id);


}