package com.proyecto.forohub.domain.topico.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.forohub.domain.ValidacionException;
import com.proyecto.forohub.domain.topico.DatosTopico;
import com.proyecto.forohub.domain.usuario.UsuarioRepository;

@Component
public class TopicoUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(DatosTopico datosTopico) {
        if (!usuarioRepository.findById(datosTopico.idUsuario()).isPresent()) {
            throw new ValidacionException("El usuario no existe");
        }
    }
}
