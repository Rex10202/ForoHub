package com.proyecto.forohub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.forohub.domain.usuario.DatosUsuario;
import com.proyecto.forohub.domain.usuario.UsuarioRepository;
import com.proyecto.forohub.domain.usuario.UsuarioService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import com.proyecto.forohub.domain.usuario.DatosActualizarUsuario;
import com.proyecto.forohub.domain.usuario.DatosListarUsuario;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity registrarUsuario(@RequestBody @Valid DatosUsuario datosUsuario) {
        var usuario = usuarioService.registrar(datosUsuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarUsuario>> listadoUsuarios(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(usuarioRepository.findAll(paginacion).map(DatosListarUsuario::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarUsuario(@RequestBody @Valid DatosActualizarUsuario actualizarDatosUsuario) {
        var usuario = usuarioService.actualizar(actualizarDatosUsuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(usuarioRepository.getReferenceById(id).getId());
        return ResponseEntity.noContent().build();
    }
}
