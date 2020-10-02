package com.example.todolist.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "categoria_tarea",
            joinColumns = @JoinColumn(name = "id_categoria"),
            inverseJoinColumns = @JoinColumn(name = "id_tarea")
    )
    private Set<Tarea> tareas = new HashSet<>();

    public void addTarea(Tarea tarea){
        this.tareas.add(tarea);
    }


}
