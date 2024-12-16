package com.notas.notas.estudiante.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.notas.dto.RespuestaDto;
import com.notas.notas.estudiante.servicio.EstudianteServicio;
import com.notas.notas.modelo.Calificacion;
import com.notas.notas.modelo.Estudiante;
import com.notas.notas.modelo.Profesor;
import com.notas.notas.repositorio.CalificacionRespositorio;
import com.notas.notas.repositorio.implementacion.EstudiateRespositoarioServicioImpl;

@Service("EstudianteServicioImpl")
public class EstudianteServicioImpl implements EstudianteServicio {

    @Autowired
    private EstudiateRespositoarioServicioImpl estudiateRespositoarioServicioImpl;

    @Autowired
    private CalificacionRespositorio calificacionRespositorio;

    @Override
    public RespuestaDto crearEstudiante(Estudiante estudiante) throws Exception {

        estudiateRespositoarioServicioImpl.guardar(estudiante);
        return new RespuestaDto("El estudiante se a creado", "0000", estudiante);
    }

    @Override
    public RespuestaDto actualizarEstudiante(Estudiante estudiante) throws Exception {

        Estudiante estuTem = estudiateRespositoarioServicioImpl.findByDocumento(estudiante.getId());
        Estudiante estu = new Estudiante();
        if (estuTem != null) {
            estu.setId(estudiante.getId());
            estu.setNombre(estudiante.getNombre());

            estudiateRespositoarioServicioImpl.guardar(estu);
            return new RespuestaDto("El estudiante se actualizo", "0000", estu);

        } else {
            return new RespuestaDto("Estudiante no encontrado", "0001", estu);
        }
    }

    @Override
    public RespuestaDto eliminarEstudiante(Estudiante estudiante) throws Exception {
        Estudiante estuTem = estudiateRespositoarioServicioImpl.findByDocumento(estudiante.getId());

        List<Calificacion> calificaciones = calificacionRespositorio.findByEstudianteId(estudiante.getId());

        if (!calificaciones.isEmpty() ) {
            return new RespuestaDto( "No se puede eliminar al estudiante ya que cuenta con una nota acignada","0001",calificaciones);
        }

        if(estuTem == null){
            return new RespuestaDto( "Estudiante no encontrado","0001",estuTem);
        }else{
            estudiateRespositoarioServicioImpl.eliminarEstudiante(estuTem);
            return new RespuestaDto( "El estudiante se Elimino","0000",estuTem);
        }
    }

}
