package com.notas.notas.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notas.notas.modelo.Estudiante;
@Repository("EstudiateRepositorio")
public interface EstudiateRepositorio extends JpaRepository<Estudiante, Serializable> {

}
