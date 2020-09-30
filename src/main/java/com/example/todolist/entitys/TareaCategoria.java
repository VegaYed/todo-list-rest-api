package com.example.todolist.entitys;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "categoria_tarea")
public class TareaCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_categoria")
    private int categoria;

    @Column(name = "id_tarea")
    private int tarea;


}
