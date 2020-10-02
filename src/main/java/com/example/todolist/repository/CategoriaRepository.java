package com.example.todolist.repository;

import com.example.todolist.entitys.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {


    Categoria getById(Integer id);




}