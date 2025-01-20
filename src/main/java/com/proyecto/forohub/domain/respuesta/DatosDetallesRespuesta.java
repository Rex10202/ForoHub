package com.proyecto.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosDetallesRespuesta(
        String contenido,
        LocalDateTime fechaCreacion,
        Long idUsuario) {

    public DatosDetallesRespuesta(Respuesta respuesta) {
        this(
                respuesta.getContenido(),
                respuesta.getFechaCreacion(),
                respuesta.getUsuario().getId());
    }
}