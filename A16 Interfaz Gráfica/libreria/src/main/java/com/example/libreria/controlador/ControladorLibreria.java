package com.example.libreria.controlador;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.libreria.model.Libros;
import com.example.libreria.servicio.IServicioLibro;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {
    private final IServicioLibro libroServicio;

    public ControladorLibreria(IServicioLibro libroServicio) {
        this.libroServicio = libroServicio;
    }

    @GetMapping("/todos")
    public List<Libros> obtenerTodos() {
        return libroServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> obtenerPorId(@PathVariable Long id) {
        return libroServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/{titulo}")
    public String dameLibro(@PathVariable String titulo) {
        return libroServicio.buscaLibroPorTitulo(titulo);
    }

    @GetMapping("/clone")
    public String probarClone() {
        Libros original = new Libros(1L, "Miguel de Cervantes", "El Quijote", LocalDate.of(1605, 1, 16));
        Libros copia = original.clone();
        return "Original: " + original + " | Copia: " + copia;
    }

    @PostMapping
    public Libros crear(@RequestBody Libros libro) {
        return libroServicio.guardar(libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        libroServicio.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
