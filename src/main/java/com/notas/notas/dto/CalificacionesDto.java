package com.notas.notas.dto;

import org.springframework.stereotype.Component;

import com.notas.notas.modelo.Estudiante;
import com.notas.notas.modelo.Profesor;

@Component
public class CalificacionesDto {

    private String nombre;

    private Long id;

    private String valor;

    private Profesor profesor;

    private Estudiante estudiante;

    public CalificacionesDto() {
    }

    public CalificacionesDto(String nombre, Long id, String valor, Profesor profesor, Estudiante estudiante) {
        this.nombre = nombre;
        this.id = id;
        this.valor = valor;
        this.profesor = profesor;
        this.estudiante = estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CalificacionesDto [nombre=" + nombre + ", id=" + id + ", valor=" + valor + ", profesor=" + profesor
                + ", estudiante=" + estudiante + "]";
    }

}
