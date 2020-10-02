package com.example.todolist.entities;

import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tarea")
@Data
@ToString
public class Tarea implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idtarea;

    @Column(name = "tarea", nullable = false, length = 50)
    private String tarea;

    @Column(name = "fecha_realizacion")
    private LocalDate fechaRealizacion;


}
