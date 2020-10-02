package com.example.todolist.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria_tarea")
public class CategoriaTareas {

    @Id
    private Integer id;

    @Column(name = "id_categoria")
    private Integer id_categoria;

    @Column(name = "id_tarea")
    private Integer id_tarea;


}
