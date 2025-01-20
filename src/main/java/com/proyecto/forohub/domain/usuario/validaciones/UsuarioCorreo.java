package com.proyecto.forohub.domain.usuario.validaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.forohub.domain.ValidacionException;
import com.proyecto.forohub.domain.usuario.DatosUsuario;
import com.proyecto.forohub.domain.usuario.UsuarioRepository;

@Component
public class UsuarioCorreo implements ValidadorDeUsuarios {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void validar(DatosUsuario datosUsuario) {
        if (usuarioRepository.existsByCorreo(datosUsuario.correo())) {
            throw new ValidacionException("El correo ya está registrado");
        }
    }

}
