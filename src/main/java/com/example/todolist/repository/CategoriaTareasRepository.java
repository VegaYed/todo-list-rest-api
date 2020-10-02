package com.example.todolist.repository;

import com.example.todolist.entities.CategoriaTareas;
import com.example.todolist.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


public interface CategoriaTareasRepository extends JpaRepository<CategoriaTareas, Integer> {


}
