package com.taller1SB.BlogPosteo.service;

import com.taller1SB.BlogPosteo.model.Autor;

import java.util.List;

public interface IautorService {
    Autor crear(Autor autor);
    Autor obtenerPorId(Long id);
    List<Autor> listar();
    Autor actualizar(Long id, Autor autor);
    void eliminar(Long id);
}
