package com.example.todolist.repository;

import com.example.todolist.entities.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query(value = "SELECT categoria.id, categoria.categoria FROM categoria, tarea INNER JOIN categoria_tarea ON categoria.id = categoria_tarea.id_categoria WHERE categoria_tarea.id_tarea = ?1", nativeQuery = true)
    List<Categoria> getCategoriasByIdTarea(Integer id);

}