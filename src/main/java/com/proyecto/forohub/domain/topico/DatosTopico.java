package com.proyecto.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopico(
        @NotBlank String titulo,
        @NotBlank String contenido,
        @NotNull Long idUsuario,
        @NotNull Long idCurso) {

    public DatosTopico(DatosActualizarTopico datosActualizarTopico) {
        this(
                datosActualizarTopico.titulo(),
                datosActualizarTopico.contenido(),
                datosActualizarTopico.idUsuario(),
                datosActualizarTopico.idCurso());
    }
}