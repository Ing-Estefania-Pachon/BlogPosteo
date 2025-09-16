package com.taller1SB.BlogPosteo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String texto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "posteo_id")
    @JsonBackReference(value = "posteo-comentarios")
    private Posteo posteo;

    public Comentario() {}

    public Comentario(Long id, String texto, Posteo posteo) {
        this.id = id;
        this.texto = texto;
        this.posteo = posteo;
    }

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public Posteo getPosteo() { return posteo; }
    public void setPosteo(Posteo posteo) { this.posteo = posteo; }
}
