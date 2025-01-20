package com.proyecto.forohub.domain.topico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.forohub.domain.curso.Curso;
import com.proyecto.forohub.domain.curso.CursoRepository;
import com.proyecto.forohub.domain.topico.validaciones.ValidadorDeTopicos;
import com.proyecto.forohub.domain.usuario.Usuario;
import com.proyecto.forohub.domain.usuario.UsuarioRepository;

@Service
public class TopicoService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    List<ValidadorDeTopicos> validadorDeTopicos;

    public DatosListarTopico registrar(DatosTopico datosTopico) {
        validadorDeTopicos.forEach(validador -> validador.validar(datosTopico));
        Usuario usuario = usuarioRepository.getReferenceById(datosTopico.idUsuario());
        Curso curso = cursoRepository.getReferenceById(datosTopico.idCurso());
        Topico topico = new Topico(datosTopico.titulo(), datosTopico.contenido(), usuario, curso);
        topicoRepository.save(topico);
        return new DatosListarTopico(topico);
    }

    public void validarTopico(Long id) {
        if (!topicoRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("El tópico no existe");
        }
    }

    public DatosListarTopico actualizar(DatosActualizarTopico datosActualizarTopico) {
        validarTopico(datosActualizarTopico.id());
        validadorDeTopicos.forEach(v -> v.validar(new DatosTopico(datosActualizarTopico)));
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.setTitulo(datosActualizarTopico.titulo());
        topico.setContenido(datosActualizarTopico.contenido());
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarTopico.idUsuario());
        topico.setUsuario(usuario);
        Curso curso = cursoRepository.getReferenceById(datosActualizarTopico.idCurso());
        topico.setCurso(curso);
        return new DatosListarTopico(topico);
    }
}
