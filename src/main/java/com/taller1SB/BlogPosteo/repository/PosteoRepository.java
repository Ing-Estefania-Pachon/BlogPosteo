package com.taller1SB.BlogPosteo.repository;

import com.taller1SB.BlogPosteo.model.Posteo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class PosteoRepository implements IposteoRepository{
    private final List<Posteo> posteos = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public PosteoRepository() {
        posteos.add(new Posteo(idGenerator.getAndIncrement(), "Primer post", "Ana"));
        posteos.add(new Posteo(idGenerator.getAndIncrement(), "Segundo post", "Carlos"));
    }

    @Override
    public List<Posteo> findAll() {
        return new ArrayList<>(posteos);
    }

    @Override
    public Posteo findById(Long id) {
        return posteos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Posteo posteo) {
        if (posteo.getId() == null) {
            posteo.setId(idGenerator.getAndIncrement());
            posteos.add(posteo);
        } else {
            for (int i = 0; i < posteos.size(); i++) {
                if (posteos.get(i).getId().equals(posteo.getId())) {
                    posteos.set(i, posteo);
                    return;
                }
            }
            posteos.add(posteo);
        }
    }
}
