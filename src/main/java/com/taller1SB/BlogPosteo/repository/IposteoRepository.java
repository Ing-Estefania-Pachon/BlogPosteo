package com.taller1SB.BlogPosteo.repository;

import com.taller1SB.BlogPosteo.model.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IposteoRepository extends JpaRepository<Posteo, Long> {
//    List<Posteo> findAll();
//    Posteo findById(Long id);
//    void save(Posteo posteo);
}