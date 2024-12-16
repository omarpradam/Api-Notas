package com.notas.notas.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.notas.modelo.Profesor;

@Repository("ProfesoresRepositorio")
public interface ProfesoresRepositorio extends JpaRepository<Profesor, Serializable> {
  

}
