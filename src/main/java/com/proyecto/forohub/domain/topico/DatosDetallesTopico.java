package com.proyecto.forohub.domain.topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.forohub.domain.respuesta.DatosDetallesRespuesta;

public record DatosDetallesTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Long idUsuario,
        Long idCurso,
        List<DatosDetallesRespuesta> respuestas) {

    public DatosDetallesTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getContenido(),
                topico.getFechaCreacion(),
                topico.getUsuario().getId(),
                topico.getCurso().getId(),
                topico.getRespuestas().stream().map(DatosDetallesRespuesta::new).collect(Collectors.toList()));
    }
}
