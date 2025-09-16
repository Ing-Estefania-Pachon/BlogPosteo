package com.taller1SB.BlogPosteo.controller;

import com.taller1SB.BlogPosteo.model.Posteo;
import com.taller1SB.BlogPosteo.service.IservicePosteo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posteos")
public class PosteoController {

    private final IservicePosteo service;

    public PosteoController(IservicePosteo service) {
        this.service = service;
    }

    @GetMapping
    public List<Posteo> getAll() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posteo> getById(@PathVariable("id") Long id) {
        Optional<Posteo> p = service.obtenerPorId(id);
        if (p.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p.get());
    }

    @PostMapping("/crear")
    public ResponseEntity<Posteo> create(@RequestBody Posteo posteo) {
        posteo.setId(null);
        Posteo guardado = service.guardar(posteo);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posteo> update(@PathVariable("id") Long id, @RequestBody Posteo posteo) {
        Optional<Posteo> existente = service.obtenerPorId(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        posteo.setId(id);
        Posteo actualizado = service.guardar(posteo);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Optional<Posteo> existente = service.obtenerPorId(id);
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el posteo con id " + id);
        }
        service.eliminar(id);
        return ResponseEntity.ok("Se eliminó correctamente el posteo con id " + id);
    }

    // endpoint para asignar autor a un post
    @PutMapping("/{postId}/autor/{autorId}")
    public ResponseEntity<Posteo> asignarAutor(@PathVariable Long postId, @PathVariable Long autorId) {
        try {
            Posteo actualizado = service.asignarAutor(postId, autorId);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
