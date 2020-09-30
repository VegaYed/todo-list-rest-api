package com.example.todolist.entitys;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tarea")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tarea")
    private String tarea;

    @Column(name = "fecha_realizacion")
    private Date fecha_realizacion;

}
