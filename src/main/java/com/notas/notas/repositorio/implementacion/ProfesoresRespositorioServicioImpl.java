package com.notas.notas.repositorio.implementacion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.notas.notas.modelo.Profesor;
import com.notas.notas.repositorio.ProfesoresRepositorio;
import com.notas.notas.repositorio.servicio.ProfesoresRespositorioServicio;

@Service("ProfesoresRespositorioServicioImpl")

public class ProfesoresRespositorioServicioImpl implements ProfesoresRespositorioServicio {

    @Autowired
    private ProfesoresRepositorio profesoresRepositorio;

    @Override
    public Profesor guardar(Profesor profesor) {
        return profesoresRepositorio.save(profesor);
    }

    @Override
    public Profesor findByDocumento(Long document) {
        Optional<Profesor> profesorTem = profesoresRepositorio.findById(document);
        Profesor profesor = new Profesor();
        if (profesorTem == null || profesorTem.isEmpty())
            return null;
        else
         profesor = profesorTem.get();
            return profesor;
    }

    @Override
    public Profesor eliminarProfesor(Profesor profesor) {

        profesoresRepositorio.delete(profesor);
        return null;

    }

}
