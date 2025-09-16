package com.taller1SB.BlogPosteo.controller;

import com.taller1SB.BlogPosteo.model.Autor;
import com.taller1SB.BlogPosteo.service.IautorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {
    private final IautorService service;
    public AutorController(IautorService service) { this.service = service; }

    @GetMapping
    public List<Autor> all() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> get(@PathVariable Long id) {
        try {
            Autor a = service.obtenerPorId(id);
            return ResponseEntity.ok(a);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Autor> create(@RequestBody Autor autor) {
        Autor creado = service.crear(autor);
        return ResponseEntity.status(201).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> update(@PathVariable Long id, @RequestBody Autor autor) {
        try {
            Autor actualizado = service.actualizar(id, autor);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
