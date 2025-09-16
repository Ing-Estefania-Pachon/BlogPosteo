package com.taller1SB.BlogPosteo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"posteos"}) // evita recursión al serializar Autor dentro de un Posteo
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Posteo> posteos = new ArrayList<>();

    public Autor() {}

    public Autor(Long id, String nombre, String email, List<Posteo> posteos) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.posteos = posteos;
    }

    // getters y setters en español
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Posteo> getPosteos() { return posteos; }
    public void setPosteos(List<Posteo> posteos) { this.posteos = posteos; }

    // helpers para mantener consistencia
    public void agregarPosteo(Posteo p) {
        posteos.add(p);
        p.setAutor(this);
    }
    public void quitarPosteo(Posteo p) {
        posteos.remove(p);
        p.setAutor(null);
    }
}
