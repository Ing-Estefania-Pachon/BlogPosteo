package com.taller1SB.BlogPosteo.service;

import com.taller1SB.BlogPosteo.model.Posteo;
import java.util.List;

public interface IservicePosteo {
    List<Posteo> findAll();
    Posteo findById(Long id);
    void save(Posteo posteo);

}
