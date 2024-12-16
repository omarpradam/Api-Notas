package com.notas.notas.estudiante.servicio;

import com.notas.notas.dto.RespuestaDto;
import com.notas.notas.modelo.Estudiante;

public interface EstudianteServicio {
    
    public RespuestaDto crearEstudiante(Estudiante estudiante) throws Exception;

    public RespuestaDto actualizarEstudiante(Estudiante estudiante) throws Exception;

    public RespuestaDto eliminarEstudiante(Estudiante estudiante) throws Exception;

}
