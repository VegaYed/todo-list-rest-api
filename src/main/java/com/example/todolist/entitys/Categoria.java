package com.example.todolist.entitys;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
@Data
@ToString
public class Categoria implements java.io.Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "categoria", nullable = false)
    private String categoria;

}
