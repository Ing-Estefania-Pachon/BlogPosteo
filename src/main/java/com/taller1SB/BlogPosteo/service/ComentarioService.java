package com.taller1SB.BlogPosteo.service;

import com.taller1SB.BlogPosteo.model.Comentario;
import com.taller1SB.BlogPosteo.model.Posteo;
import com.taller1SB.BlogPosteo.repository.IcomentarioRepository;
import com.taller1SB.BlogPosteo.repository.IposteoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ComentarioService implements IcomentarioService {

    private final IcomentarioRepository comentarioRepo;
    private final IposteoRepository posteoRepo;

    public ComentarioService(IcomentarioRepository comentarioRepo, IposteoRepository posteoRepo) {
        this.comentarioRepo = comentarioRepo;
        this.posteoRepo = posteoRepo;
    }

    @Override
    public Comentario crearComentarioEnPost(Long idPosteo, Comentario comentario) {
        Posteo post = posteoRepo.findById(idPosteo)
                .orElseThrow(() -> new RuntimeException("Posteo no encontrado"));
        comentario.setPosteo(post);
        Comentario saved = comentarioRepo.save(comentario);
        post.getComentarios().add(saved); // coherencia en memoria
        posteoRepo.save(post);
        return saved;
    }
}
