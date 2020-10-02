package com.example.todolist.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "categoria_tarea")
@Data
public class CategoriaTareas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_categoria")
    private Integer id_categoria;

    @Column(name = "id_tarea")
    private Integer id_tarea;


}
