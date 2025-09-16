package com.taller1SB.BlogPosteo.service;

import com.taller1SB.BlogPosteo.model.Posteo;

import java.util.List;
import java.util.Optional;

public interface IservicePosteo {
    List<Posteo> listar();
    Optional<Posteo> obtenerPorId(Long id);
    Posteo guardar(Posteo posteo);
    void eliminar(Long id);

    Posteo asignarAutor(Long idPosteo, Long idAutor);
}
