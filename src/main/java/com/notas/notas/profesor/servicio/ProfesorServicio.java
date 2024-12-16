package com.notas.notas.profesor.servicio;


import com.notas.notas.dto.RespuestaDto;
import com.notas.notas.modelo.Profesor;

public interface ProfesorServicio {

    public RespuestaDto crearProfesor(Profesor profesorDto) throws Exception;

    public RespuestaDto actualizarProfesor(Profesor profesorDto) throws Exception;

    public RespuestaDto eliminarProfesor(Profesor profesorDto) throws Exception;

}
