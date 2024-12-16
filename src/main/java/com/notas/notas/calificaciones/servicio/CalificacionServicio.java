package com.notas.notas.calificaciones.servicio;

import com.notas.notas.dto.CalificacionesDto;
import com.notas.notas.dto.RespuestaDto;

public interface CalificacionServicio {


    public RespuestaDto crearCalificacion(CalificacionesDto calificacionesDto) throws Exception;

    public RespuestaDto actualizarCalificacion(CalificacionesDto calificacionesDto) throws Exception;

    public RespuestaDto eliminarCalificacion(CalificacionesDto CalificacionesDto) throws Exception;
}
