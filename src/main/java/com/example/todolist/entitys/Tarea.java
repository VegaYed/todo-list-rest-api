package com.example.todolist.entitys;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tarea")
@Data
@ToString
public class Tarea implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idtarea;

    @Column(name = "tarea", nullable = false)
    private String tarea;

    @Column(name = "fecha_realizacion")
    private LocalDate fechaRealizacion;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tareas")
    private Set<Categoria> categorias = new HashSet<>();





}
