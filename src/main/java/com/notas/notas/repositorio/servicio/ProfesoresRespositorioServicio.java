package com.notas.notas.repositorio.servicio;

import com.notas.notas.modelo.Profesor;

public interface ProfesoresRespositorioServicio {

    public Profesor guardar(Profesor profesor);
	public Profesor findByDocumento(Long document);
	public Profesor eliminarProfesor(Profesor profesor);

}
