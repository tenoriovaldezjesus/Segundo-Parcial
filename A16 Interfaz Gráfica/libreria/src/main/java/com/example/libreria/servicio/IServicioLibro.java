package com.example.libreria.servicio;

import java.util.List;
import java.util.Optional;
import com.example.libreria.model.Libros;

public interface IServicioLibro {
    List<Libros> obtenerTodos();
    Optional<Libros> obtenerPorId(Long id);
    Libros guardar(Libros libro);
    void eliminarPorId(Long id);
    String buscaLibroPorTitulo(String titulo);
}
