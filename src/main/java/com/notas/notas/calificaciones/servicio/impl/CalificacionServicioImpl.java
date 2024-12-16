package com.notas.notas.calificaciones.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.notas.calificaciones.servicio.CalificacionServicio;
import com.notas.notas.dto.CalificacionesDto;
import com.notas.notas.dto.RespuestaDto;
import com.notas.notas.modelo.Calificacion;
import com.notas.notas.repositorio.CalificacionRespositorio;
import com.notas.notas.repositorio.implementacion.CalificacionRespositariServicioImpl;

@Service("CalificacionServicioImpl")
public class CalificacionServicioImpl implements CalificacionServicio {

    @Autowired
    private CalificacionRespositariServicioImpl calificacionRespositariServicioImpl;

    @Autowired
    private CalificacionRespositorio calificacionRespositorio;

    @Override
    public RespuestaDto crearCalificacion(CalificacionesDto calificacionesDto) throws Exception {
       
        calificacionRespositariServicioImpl.guardar(calificacionesDto);

         return new RespuestaDto("La nota se a creado","0000", calificacionesDto);
    }

    @Override
    public RespuestaDto actualizarCalificacion(CalificacionesDto calificacionesDto) throws Exception {
        
          Calificacion calTem = calificacionRespositariServicioImpl.findByCalificacion(calificacionesDto.getId());
          
        if (calTem != null) {  
            calTem.setProfesor(calificacionesDto.getProfesor());
            calTem.setEstudiante(calificacionesDto.getEstudiante());
            Float valor = Float.parseFloat(calificacionesDto.getValor());
            calTem.setValor(valor);
            calTem.setNombre(calificacionesDto.getNombre());
            calTem.setId(calificacionesDto.getId());
            calificacionRespositorio.save(calTem);
            return new RespuestaDto("La nota se actualizo", "0000", calificacionesDto);

        } else {
            return new RespuestaDto("Nota no encontrada", "0001", calificacionesDto);
        }
    }

    @Override
    public RespuestaDto eliminarCalificacion(CalificacionesDto CalificacionesDto) throws Exception {
        Calificacion calTem = calificacionRespositariServicioImpl.findByCalificacion(CalificacionesDto.getId());
        if (calTem != null) {
            calificacionRespositariServicioImpl.eliminarCalifiacion(calTem);
            return new RespuestaDto("La nota se elimino", "0000", CalificacionesDto);

        } else {
            return new RespuestaDto("Nota no encontrada", "0001", CalificacionesDto);
        }
    }

}
