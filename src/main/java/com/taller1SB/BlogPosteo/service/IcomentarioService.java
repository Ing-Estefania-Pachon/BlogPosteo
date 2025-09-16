package com.taller1SB.BlogPosteo.service;

import com.taller1SB.BlogPosteo.model.Comentario;

public interface IcomentarioService {
    Comentario crearComentarioEnPost(Long idPosteo, Comentario comentario);
}
