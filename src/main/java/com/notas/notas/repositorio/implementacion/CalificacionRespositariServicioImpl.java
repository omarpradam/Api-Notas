package com.notas.notas.repositorio.implementacion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.notas.notas.dto.CalificacionesDto;
import com.notas.notas.modelo.Calificacion;
import com.notas.notas.repositorio.CalificacionRespositorio;
import com.notas.notas.repositorio.servicio.CalificacionRespositaoriServicio;

@Service("CalificacionRespositariServicioImpl")
@Qualifier()
public class CalificacionRespositariServicioImpl  implements CalificacionRespositaoriServicio{

    @Autowired
    private CalificacionRespositorio calificacionRespositorio;


    @Override
    public Calificacion eliminarCalifiacion(Calificacion calificacion) {
       
        calificacionRespositorio.delete(calificacion);
            return null;
    }

    @Override
    public Calificacion guardar(CalificacionesDto calificacion) {
        Calificacion calificacionTem = new Calificacion();
        calificacionTem.setProfesor(calificacion.getProfesor());
        calificacionTem.setEstudiante(calificacion.getEstudiante());
        Float valor = Float.parseFloat(calificacion.getValor());
        calificacionTem.setValor(valor);
        calificacionTem.setNombre(calificacion.getNombre());
        return calificacionRespositorio.save(calificacionTem);
    }

    @Override
    public Calificacion findByCalificacion(Long id) {

        Optional<Calificacion> califiTem = calificacionRespositorio.findById(id);
        Calificacion calificaTem = new Calificacion();

        if (califiTem == null || califiTem.isEmpty())
            return null;
        else
        calificaTem = califiTem.get();
            return calificaTem;
    }

}
