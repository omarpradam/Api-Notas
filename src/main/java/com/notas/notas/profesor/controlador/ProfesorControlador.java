package com.notas.notas.profesor.controlador;

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
import com.notas.notas.modelo.Profesor;
import com.notas.notas.profesor.servicio.impl.ProfesorServicioImpl;

@RestController
@RequestMapping("/Profesor")
public class ProfesorControlador {

    private RespuestaDto respuestaDto = null;

    @Autowired
    private ProfesorServicioImpl profesorServicioImpl;

    @PostMapping(value = "/profesorCrear", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RespuestaDto creacion(@RequestBody Profesor profesorDto) {
        try {

            return profesorServicioImpl.crearProfesor(profesorDto);

        } catch (Exception e) {
            e.getMessage();
            return respuestaDto = new RespuestaDto("Error", "400", false);
        }

    }

    @DeleteMapping(value = "/profesorEliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RespuestaDto eliminacion(@RequestBody Profesor profesorDto) {
        try {
            return profesorServicioImpl.eliminarProfesor(profesorDto);
        } catch (Exception e) {
            e.getMessage();
            return respuestaDto = new RespuestaDto("Error", "400", false);
        }

    }

    @PutMapping(value = "/profesorActualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RespuestaDto actualizacion(@RequestBody Profesor profesorDto) {
        try {

            return profesorServicioImpl.actualizarProfesor(profesorDto);

        } catch (Exception e) {
            e.getMessage();
            return respuestaDto = new RespuestaDto("Error", "400", false);
        }
    }
}
