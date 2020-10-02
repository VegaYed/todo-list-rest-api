package com.example.todolist.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "categoria")
@Data
@ToString
public class Categoria implements java.io.Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(min = 5, max = 50)
    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

}
