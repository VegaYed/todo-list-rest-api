package com.example.todolist.repository;

import com.example.todolist.entitys.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {



}