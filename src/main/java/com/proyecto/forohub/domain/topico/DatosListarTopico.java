package com.proyecto.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosListarTopico(
        String titulo,
        String contenido,
        LocalDateTime fechaCreacion,
        Long idUsuario,
        Long idCurso) {

    public DatosListarTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getContenido(),
                topico.getFechaCreacion(),
                topico.getUsuario().getId(),
                topico.getCurso().getId());
    }
}