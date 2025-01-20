package com.proyecto.forohub.domain.respuesta.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.forohub.domain.ValidacionException;
import com.proyecto.forohub.domain.respuesta.DatosRespuesta;
import com.proyecto.forohub.domain.topico.TopicoRepository;

@Component
public class RespuestaTopico implements ValidadorDeRespuestas {
    @Autowired
    TopicoRepository topicoRepository;

    public void validar(DatosRespuesta datosRespuesta) {
        if (!topicoRepository.findById(datosRespuesta.idTopico()).isPresent()) {
            throw new ValidacionException("El tópico no existe");
        }
    }

}
