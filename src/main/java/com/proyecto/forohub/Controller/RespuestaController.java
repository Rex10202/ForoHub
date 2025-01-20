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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.forohub.domain.respuesta.DatosActualizarRespuesta;
import com.proyecto.forohub.domain.respuesta.DatosListarRespuesta;
import com.proyecto.forohub.domain.respuesta.DatosRespuesta;
import com.proyecto.forohub.domain.respuesta.RespuestaRepository;
import com.proyecto.forohub.domain.respuesta.RespuestaService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@ResponseBody
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    RespuestaService respuestaService;
    @Autowired
    RespuestaRepository respuestaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarRespuesta(@RequestBody @Valid DatosRespuesta datosRespuesta) {
        var respuesta = respuestaService.registrar(datosRespuesta);
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListarRespuesta>> listarRespuestas(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(respuestaRepository.findAll(pageable).map(DatosListarRespuesta::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarRespuesta(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta) {
        var respuesta = respuestaService.actualizar(datosActualizarRespuesta);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        respuestaService.validarRespuesta(id);
        respuestaRepository.deleteById(respuestaRepository.getReferenceById(id).getId());
        return ResponseEntity.noContent().build();
    }
}
