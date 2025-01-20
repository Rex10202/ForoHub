package com.proyecto.forohub.domain.respuesta.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.forohub.domain.ValidacionException;
import com.proyecto.forohub.domain.respuesta.DatosRespuesta;
import com.proyecto.forohub.domain.usuario.UsuarioRepository;

@Component
public class RespuestaUsuario {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void validar(DatosRespuesta datosRespuesta) {
        if (!usuarioRepository.findById(datosRespuesta.idUsuario()).isPresent()) {
            throw new ValidacionException("El usuario no existe");
        }
    }
}
