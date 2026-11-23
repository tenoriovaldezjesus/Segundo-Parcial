package com.example.libreria.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.libreria.model.Libros;
import com.example.libreria.repolibros.IRepoLibros;

@Service
public class ServicioLibro implements IServicioLibro {
    private final IRepoLibros iRepo;

    @Autowired
    public ServicioLibro(IRepoLibros iRepo) {
        this.iRepo = iRepo;
    }

    @Override
    public List<Libros> obtenerTodos() {
        return iRepo.findAll();
    }

    @Override
    public Optional<Libros> obtenerPorId(Long id) {
        return iRepo.findById(id);
    }

    @Override
    public Libros guardar(Libros libro) {
        iRepo.save(libro);
        return libro;
    }

    @Override
    public void eliminarPorId(Long id) {
        iRepo.deleteById(id);
    }

    @Override
    public String buscaLibroPorTitulo(String titulo) {
        boolean existe = iRepo.findAll().stream()
                .anyMatch(l -> l.getTitulo().equalsIgnoreCase(titulo));
        return existe ? "Libro encontrado" : "Libro no encontrado";
    }
}
