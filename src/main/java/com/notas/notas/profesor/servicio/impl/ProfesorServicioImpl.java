package com.notas.notas.profesor.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.notas.notas.dto.RespuestaDto;
import com.notas.notas.modelo.Calificacion;
import com.notas.notas.modelo.Profesor;
import com.notas.notas.profesor.servicio.ProfesorServicio;
import com.notas.notas.repositorio.CalificacionRespositorio;
import com.notas.notas.repositorio.implementacion.ProfesoresRespositorioServicioImpl;

@Service("ProfesorServicioImpl")
public class ProfesorServicioImpl implements ProfesorServicio {

    @Autowired
    private ProfesoresRespositorioServicioImpl profesoresRespositorioServicioImpl;

    @Autowired
    private CalificacionRespositorio calificacionRespositorio;

    @Override
    public RespuestaDto crearProfesor(Profesor profesorDto) throws Exception {
        
        
        profesoresRespositorioServicioImpl.guardar(profesorDto);
         return new RespuestaDto("El profesor se a creado","0000", profesorDto);
    }

    @Override
    public RespuestaDto actualizarProfesor(Profesor profesorDto) throws Exception {
        
         Profesor proTem = profesoresRespositorioServicioImpl.findByDocumento(profesorDto.getId());
         Profesor pro = new Profesor();
         if(proTem != null){    
            pro.setId(profesorDto.getId());
            pro.setNombre(profesorDto.getNombre());
            profesoresRespositorioServicioImpl.guardar(pro);
            return new RespuestaDto( "El profesor se actualizo","0000",pro);

         }else{
            return new RespuestaDto( "Profesor no encontrado","0001",proTem);
         }

    }

    @Override
    public RespuestaDto eliminarProfesor(Profesor profesorDto) throws Exception {
        Long id = Long.valueOf(profesorDto.getId());
        Profesor proTem = profesoresRespositorioServicioImpl.findByDocumento(id);

      List<Calificacion> calificaciones = calificacionRespositorio.findByProfesorId(id);

        if (!calificaciones.isEmpty() ) {
            return new RespuestaDto( "No se puede eliminar al profesor ya que cuenta con una nota acignada","0001",calificaciones);
        }

        if(proTem == null){
            return new RespuestaDto( "Profesor no encontrado","0001",proTem);
        }else
        {
            
            profesoresRespositorioServicioImpl.eliminarProfesor(proTem);
            return new RespuestaDto( "El profesor se Elimino","0000",proTem);
        }
       
    }

   

}
