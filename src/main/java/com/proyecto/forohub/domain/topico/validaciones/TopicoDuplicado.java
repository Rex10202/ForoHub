package com.proyecto.forohub.domain.topico.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.forohub.domain.ValidacionException;
import com.proyecto.forohub.domain.topico.DatosTopico;
import com.proyecto.forohub.domain.topico.TopicoRepository;

@Component
public class TopicoDuplicado implements ValidadorDeTopicos {
    @Autowired
    private TopicoRepository topicoRepository;

    public void validar(DatosTopico datosTopico) {
        if (!topicoRepository.findTopicoDuplicado(datosTopico.titulo(), datosTopico.contenido()).isEmpty()) {
            throw new ValidacionException("El tópico ya existe");
        }
    }
}
