package com.notas.notas.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "calificacion")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name ="id")
    private Long id;
    @Column(name ="nombre")
    private String nombre;
    @Column(name ="valor")
    private Float valor;

    @ManyToOne
    @JoinColumn(name = "idProfesor", referencedColumnName = "id", nullable = false)
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "idEstudiante", referencedColumnName = "id", nullable = false)
    private Estudiante estudiante;

    public Calificacion() {
    }

    public Calificacion(String nombre, Float valor, Profesor profesor, Estudiante estudiante) {
        this.nombre = nombre;
        this.valor = valor;
        this.profesor = profesor;
        this.estudiante = estudiante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

}
