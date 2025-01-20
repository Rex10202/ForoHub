package com.proyecto.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRespuesta(
        @NotBlank String contenido,
        @NotNull Long idTopico,
        @NotNull Long idUsuario) {
}
