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
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Posteo>> getById(@PathVariable("id") Long id) {
        Optional<Posteo> p = service.findById(id);
        if (p.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(p);
    }

    @PostMapping("/crear")
    public ResponseEntity<Posteo> create(@RequestBody Posteo posteo) {
        posteo.setId(null);
        service.save(posteo);
        return ResponseEntity.status(HttpStatus.CREATED).body(posteo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posteo> update(@PathVariable("id") Long id, @RequestBody Posteo posteo) {
        Optional<Posteo> existente = service.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        posteo.setId(id);
        service.save(posteo);
        return ResponseEntity.ok(posteo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Optional<Posteo> existente = service.findById(id);
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el posteo con id " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Se eliminó correctamente el posteo con id " + id);
    }


}