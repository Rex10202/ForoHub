package com.proyecto.forohub.domain.topico;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAllByOrderByFechaCreacionAsc(org.springframework.data.domain.Pageable pageable);

    @Query("SELECT t FROM Topico t WHERE t.titulo=:titulo AND t.contenido=:contenido")
    List<Topico> findTopicoDuplicado(String titulo, String contenido);
}
