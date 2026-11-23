package com.example.libreria.util;

import org.springframework.stereotype.Component;
import com.example.libreria.model.Libros;

@Component
public class ValidaLibros {
    public boolean tituloValido(Libros libro) {
        return libro != null && libro.getTitulo() != null && !libro.getTitulo().isBlank();
    }
}
