package com.taller1SB.BlogPosteo.repository;

import com.taller1SB.BlogPosteo.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcomentarioRepository extends JpaRepository<Comentario, Long> {
}
