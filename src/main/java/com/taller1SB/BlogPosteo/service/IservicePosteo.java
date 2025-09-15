package com.taller1SB.BlogPosteo.service;

import com.taller1SB.BlogPosteo.model.Posteo;
import java.util.List;
import java.util.Optional;

public interface IservicePosteo {
    List<Posteo> findAll();
    Optional<Posteo> findById(Long id);
    void save(Posteo posteo);

    void delete(Long id);
}
