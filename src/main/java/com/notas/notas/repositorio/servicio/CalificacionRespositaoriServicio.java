package com.notas.notas.repositorio.servicio;

import com.notas.notas.dto.CalificacionesDto;
import com.notas.notas.modelo.Calificacion;

public interface CalificacionRespositaoriServicio {

    public Calificacion eliminarCalifiacion(Calificacion calificacion);

    public Calificacion guardar(CalificacionesDto calificacion);

    public Calificacion findByCalificacion(Long id);
}
