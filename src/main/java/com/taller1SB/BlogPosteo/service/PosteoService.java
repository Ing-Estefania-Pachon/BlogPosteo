package com.taller1SB.BlogPosteo.service;

import com.taller1SB.BlogPosteo.model.Autor;
import com.taller1SB.BlogPosteo.model.Posteo;
import com.taller1SB.BlogPosteo.repository.IautorRepository;
import com.taller1SB.BlogPosteo.repository.IposteoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PosteoService implements IservicePosteo {

    private final IposteoRepository repository;
    private final IautorRepository autorRepository;

    public PosteoService(IposteoRepository repository, IautorRepository autorRepository) {
        this.repository = repository;
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Posteo> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<Posteo> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Posteo guardar(Posteo posteo) {
        return repository.save(posteo);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Posteo asignarAutor(Long idPosteo, Long idAutor) {
        Posteo posteo = repository.findById(idPosteo)
                .orElseThrow(() -> new RuntimeException("Posteo no encontrado"));
        Autor autor = autorRepository.findById(idAutor)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        posteo.setAutor(autor);

        if (!autor.getPosteos().contains(posteo)) {
            autor.getPosteos().add(posteo);
        }
        return repository.save(posteo);
    }
}
