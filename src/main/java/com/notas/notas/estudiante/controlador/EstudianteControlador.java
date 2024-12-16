package com.notas.notas.estudiante.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.notas.notas.dto.RespuestaDto;
import com.notas.notas.estudiante.servicio.impl.EstudianteServicioImpl;
import com.notas.notas.modelo.Estudiante;

@RestController
@RequestMapping("/Estudiante")
public class EstudianteControlador {

    private RespuestaDto respuestaDto = null;

    @Autowired
    private EstudianteServicioImpl estudianteServicioImpl;

    @PostMapping(value = "/estudianteCrear", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RespuestaDto creacion(@RequestBody Estudiante estudianteDto) {
        try {

            return estudianteServicioImpl.crearEstudiante(estudianteDto);

        } catch (Exception e) {
            e.getMessage();
            return respuestaDto = new RespuestaDto("Error", "400", false);
        }

    }

    @DeleteMapping(value = "/estudianteEliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RespuestaDto eliminacion(@RequestBody Estudiante estudianteDto) {
        try {
            return estudianteServicioImpl.eliminarEstudiante(estudianteDto);
        } catch (Exception e) {
            e.getMessage();
            return respuestaDto = new RespuestaDto("Error", "400", false);
        }

    }

    @PutMapping(value = "/estudianteActualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RespuestaDto actualizacion(@RequestBody Estudiante estudianteDto) {
        try {

            return estudianteServicioImpl.actualizarEstudiante(estudianteDto);

        } catch (Exception e) {
            e.getMessage();
            return respuestaDto = new RespuestaDto("Error", "400", false);
        }
    }

}
