package com.notas.notas.repositorio.servicio;

import com.notas.notas.modelo.Estudiante;

public interface EstudianteRespositorioServicio {

    public Estudiante guardar(Estudiante estudiante);

    public Estudiante findByDocumento(Long document);

    public Estudiante eliminarEstudiante(Estudiante estudiante);

}
