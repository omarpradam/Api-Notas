package com.notas.notas.calificaciones.controlador;

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

import com.notas.notas.calificaciones.servicio.impl.CalificacionServicioImpl;
import com.notas.notas.dto.CalificacionesDto;
import com.notas.notas.dto.RespuestaDto;


@RestController
@RequestMapping("/Califiaciones")
public class CalificacionControlador {

    private RespuestaDto respuestaDto = null;

    @Autowired
    private CalificacionServicioImpl calificacionServicioImpl;

    @PostMapping(value = "/calificacionCrear", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RespuestaDto creacion(@RequestBody CalificacionesDto calificacionesDto) {
        try {

            return calificacionServicioImpl.crearCalificacion(calificacionesDto);

        } catch (Exception e) {
            e.getMessage();
            return respuestaDto = new RespuestaDto("Error", "400", false);
        }

    }

     @DeleteMapping(value = "/calificacionEliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RespuestaDto eliminacion(@RequestBody CalificacionesDto calificacionesDto) {
        try {
            return calificacionServicioImpl.eliminarCalificacion(calificacionesDto);
        } catch (Exception e) {
            e.getMessage();
            return respuestaDto = new RespuestaDto("Error", "400", false);
        }

    }

    @PutMapping(value = "/calificacionActualizar", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RespuestaDto actualizacion(@RequestBody CalificacionesDto calificacionesDto) {
        try {

            return calificacionServicioImpl.actualizarCalificacion(calificacionesDto);

        } catch (Exception e) {
            e.getMessage();
            return respuestaDto = new RespuestaDto("Error", "400", false);
        }
    }

}

