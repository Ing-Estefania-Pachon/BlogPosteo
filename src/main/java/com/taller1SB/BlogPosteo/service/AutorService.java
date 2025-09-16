package com.taller1SB.BlogPosteo.service;

import com.taller1SB.BlogPosteo.model.Autor;
import com.taller1SB.BlogPosteo.repository.IautorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AutorService implements IautorService {
    private final IautorRepository repo;
    public AutorService(IautorRepository repo) { this.repo = repo; }

    @Override
    public Autor crear(Autor autor) {
        if (repo.existsByEmail(autor.getEmail())) {
            throw new IllegalArgumentException("Email ya registrado");
        }
        return repo.save(autor);
    }

    @Override
    public Autor obtenerPorId(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    @Override
    public List<Autor> listar() { return repo.findAll(); }

    @Override
    public Autor actualizar(Long id, Autor autor) {
        Autor existente = obtenerPorId(id);
        existente.setNombre(autor.getNombre());
        existente.setEmail(autor.getEmail());
        return repo.save(existente);
    }

    @Override
    public void eliminar(Long id) { repo.deleteById(id); }
}
