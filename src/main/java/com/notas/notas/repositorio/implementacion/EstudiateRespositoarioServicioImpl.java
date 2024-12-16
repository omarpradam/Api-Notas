package com.notas.notas.repositorio.implementacion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.notas.notas.modelo.Estudiante;
import com.notas.notas.repositorio.EstudiateRepositorio;
import com.notas.notas.repositorio.servicio.EstudianteRespositorioServicio;

@Service("EstudiateRespositoarioServicioImpl")

public class EstudiateRespositoarioServicioImpl implements EstudianteRespositorioServicio{
    @Autowired
    private EstudiateRepositorio estudiateRepositorio;

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return estudiateRepositorio.save(estudiante);
    }

    @Override
    public Estudiante findByDocumento(Long document) {
       Optional<Estudiante> estudianteTem = estudiateRepositorio.findById(document);
       Estudiante estudiante = new Estudiante();
        if (estudianteTem == null || estudianteTem.isEmpty())
            return null;
        else
        estudiante = estudianteTem.get();
            return estudiante;
    }

    @Override
    public Estudiante eliminarEstudiante(Estudiante estudiante) {
       estudiateRepositorio.delete(estudiante);
       return null;
    }

}
