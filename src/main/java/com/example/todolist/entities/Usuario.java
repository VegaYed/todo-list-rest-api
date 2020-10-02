package com.example.todolist.entities;

import java.io.Serializable;
import javax.persistence.*;
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

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "password", nullable = false, length = 20)
    private String password;

}
