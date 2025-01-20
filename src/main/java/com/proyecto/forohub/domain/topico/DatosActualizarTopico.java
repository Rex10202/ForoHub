package com.proyecto.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        @NotBlank String titulo,
        @NotBlank String contenido,
        @NotNull Long idUsuario,
        @NotNull Long idCurso) {
}
