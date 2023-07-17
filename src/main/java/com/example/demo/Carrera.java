package com.example.demo;

//import org.hibernate.mapping.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import java.util.Set;
import java.util.HashSet;


@Entity
@Table(name= "carrera")
public class Carrera {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String nombre;

    @OneToMany(targetEntity = Curso.class,mappedBy = "carrera")
    @OrderBy("nombre ASC")
    private Set<Curso> cursos = new HashSet<Curso>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
   
}
