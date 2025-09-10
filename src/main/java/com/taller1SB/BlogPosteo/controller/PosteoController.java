package com.taller1SB.BlogPosteo.controller;

import com.taller1SB.BlogPosteo.model.Posteo;
import com.taller1SB.BlogPosteo.service.IservicePosteo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Posteo> getById(@PathVariable("id") Long id) {
        Posteo p = service.findById(id);
        if (p == null) {
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
}