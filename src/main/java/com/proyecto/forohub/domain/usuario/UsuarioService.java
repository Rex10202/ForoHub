package com.proyecto.forohub.domain.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.forohub.domain.usuario.validaciones.ValidadorDeUsuarios;

@Service
public class UsuarioService {

    @Autowired
    List<ValidadorDeUsuarios> validadorDeUsuarios;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public DatosListarUsuario registrar(DatosUsuario datosUsuario) {
        validadorDeUsuarios.forEach(validador -> validador.validar(datosUsuario));
        Usuario usuario = new Usuario(datosUsuario, passwordEncoder);
        usuarioRepository.save(usuario);
        return new DatosListarUsuario(usuario);
    }

    public DatosListarUsuario actualizar(DatosActualizarUsuario datosActualizarUsuario) {
        validadorDeUsuarios.forEach(validador -> validador.validar(new DatosUsuario(datosActualizarUsuario)));
        var usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.actualizarUsuario(datosActualizarUsuario, passwordEncoder);
        return new DatosListarUsuario(usuario);
    }
}
