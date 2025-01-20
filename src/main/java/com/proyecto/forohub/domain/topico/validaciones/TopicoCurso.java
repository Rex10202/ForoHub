package com.proyecto.forohub.domain.topico.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.forohub.domain.ValidacionException;
import com.proyecto.forohub.domain.curso.CursoRepository;
import com.proyecto.forohub.domain.topico.DatosTopico;

@Component
public class TopicoCurso {

    @Autowired
    CursoRepository cursoRepository;

    public void validar(DatosTopico datosTopico) {
        if (!cursoRepository.findById(datosTopico.idCurso()).isPresent()) {
            throw new ValidacionException("El curso no existe");
        }
    }
}
