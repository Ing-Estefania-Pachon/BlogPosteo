package com.taller1SB.BlogPosteo.service;

import com.taller1SB.BlogPosteo.model.Posteo;
import com.taller1SB.BlogPosteo.repository.IposteoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteoService implements IservicePosteo {

    private final IposteoRepository repository;

    public PosteoService(IposteoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Posteo> findAll() {
        return repository.findAll();
    }

    @Override
    public Posteo findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Posteo posteo) {
        repository.save(posteo);
    }
}

