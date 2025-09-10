package com.taller1SB.BlogPosteo.repository;

import com.taller1SB.BlogPosteo.model.Posteo;

import java.util.List;

public interface IposteoRepository {
    List<Posteo> findAll();
    Posteo findById(Long id);
    void save(Posteo posteo);
}