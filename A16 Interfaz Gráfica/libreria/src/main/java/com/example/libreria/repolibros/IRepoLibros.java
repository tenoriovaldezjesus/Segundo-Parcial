package com.example.libreria.repolibros;

import java.util.List;
import java.util.Optional;
import com.example.libreria.model.Libros;

public interface IRepoLibros {
    List<Libros> findAll();
    Optional<Libros> findById(Long id);
    void save(Libros libro);
    void deleteById(Long id);
}
