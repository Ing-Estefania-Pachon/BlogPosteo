package com.taller1SB.BlogPosteo.repository;

import com.taller1SB.BlogPosteo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IautorRepository extends JpaRepository<Autor, Long> {
    boolean existsByEmail(String email);
}
