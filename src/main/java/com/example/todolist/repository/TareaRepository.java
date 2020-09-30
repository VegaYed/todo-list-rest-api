package com.example.todolist.repository;

import com.example.todolist.entitys.Tarea;
import org.springframework.data.repository.CrudRepository;

public interface TareaRepository extends CrudRepository<Tarea, Integer> {
}
