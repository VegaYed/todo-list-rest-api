package com.example.todolist.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario", nullable = false)
    private Integer idusuario;

    @Size(min = 5, max = 20)
    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Size(min = 5, max = 20)
    @Column(name = "password", nullable = false, length = 20)
    private String password;

}
