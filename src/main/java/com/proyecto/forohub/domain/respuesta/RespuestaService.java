package com.proyecto.forohub.domain.respuesta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.forohub.domain.respuesta.validaciones.ValidadorDeRespuestas;
import com.proyecto.forohub.domain.topico.Topico;
import com.proyecto.forohub.domain.topico.TopicoRepository;
import com.proyecto.forohub.domain.usuario.Usuario;
import com.proyecto.forohub.domain.usuario.UsuarioRepository;

@Service
public class RespuestaService {

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    List<ValidadorDeRespuestas> validadorDeRespuestas;

    public DatosListarRespuesta registrar(DatosRespuesta datosRespuesta) {
        validadorDeRespuestas.forEach(v -> v.validar(datosRespuesta));
        Topico topico = topicoRepository.findById(datosRespuesta.idTopico()).get();
        Usuario usuario = usuarioRepository.findById(datosRespuesta.idUsuario()).get();
        Respuesta respuesta = new Respuesta(
                datosRespuesta.contenido(),
                topico,
                usuario);
        respuestaRepository.save(respuesta);
        return new DatosListarRespuesta(respuesta);
    }

    public void validarRespuesta(Long id) {
        if (!respuestaRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("La respuesta no existe");
        }
    }

    public DatosListarRespuesta actualizar(DatosActualizarRespuesta datosActualizarRespuesta) {
        validarRespuesta(datosActualizarRespuesta.id());
        Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.id());
        respuesta.setContenido(datosActualizarRespuesta.contenido());
        return new DatosListarRespuesta(respuesta);
    }
}
