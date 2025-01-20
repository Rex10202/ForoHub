package com.proyecto.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosListarRespuesta(
        String contenido,
        Long topico,
        Long idUsuario,
        LocalDateTime fechaCreacion) {

    public DatosListarRespuesta(Respuesta respuesta) {
        this(
                respuesta.getContenido(),
                respuesta.getTopico().getId(),
                respuesta.getUsuario().getId(),
                respuesta.getFechaCreacion());
    }
}
