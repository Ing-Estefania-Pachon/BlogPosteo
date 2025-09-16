package com.taller1SB.BlogPosteo.controller;

import com.taller1SB.BlogPosteo.model.Comentario;
import com.taller1SB.BlogPosteo.service.IcomentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posteos")
public class ComentarioController {

    private final IcomentarioService service;

    public ComentarioController(IcomentarioService service) {
        this.service = service;
    }

    @PostMapping("/{postId}/comentarios")
    public ResponseEntity<Comentario> addComment(@PathVariable Long postId, @RequestBody Comentario comentario) {
        Comentario creado = service.crearComentarioEnPost(postId, comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}
