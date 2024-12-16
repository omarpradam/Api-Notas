package com.notas.notas.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.notas.modelo.Calificacion;

@Repository("CalificacionRespositorio")
public interface CalificacionRespositorio extends JpaRepository<Calificacion, Serializable> {

    List<Calificacion> findByEstudianteId(Long idEstudiante);
    List<Calificacion> findByProfesorId(Long idProfesor);

}
