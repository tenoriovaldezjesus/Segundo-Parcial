package com.hibernate.ferreteria.servicios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hibernate.ferreteria.dto.ArticulosDTO;
import com.hibernate.ferreteria.entity.Articulos;
import com.hibernate.ferreteria.mapper.ArticuloMapper;
import com.hibernate.ferreteria.repositorios.RepoArticulos;

@Service
public class ArticuloService {

    @Autowired
    private RepoArticulos repo;

    public List<ArticulosDTO> servConsulta() {
        return repo.findAll()
                .stream()
                .map(ArticuloMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ArticulosDTO servBuscaId(Long id) {
        Articulos art = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado con ID: " + id));
        return ArticuloMapper.toDTO(art);
    }

    public ArticulosDTO servInserta(ArticulosDTO dto) {
        Articulos entidad = ArticuloMapper.toEntity(dto);
        entidad.setId(null);
        Articulos guardado = repo.save(entidad);
        return ArticuloMapper.toDTO(guardado);
    }

    public ArticulosDTO servActualiza(Long id, ArticulosDTO dto) {
        Optional<Articulos> opt = repo.findById(id);
        if (opt.isEmpty()) {
            throw new RuntimeException("Artículo no encontrado con ID: " + id);
        }
        Articulos art = opt.get();
        art.setNombreArticulo(dto.getNombreArticulo());
        art.setPrecio(dto.getPrecio());
        art.setExistencia(dto.getExistencia());
        return ArticuloMapper.toDTO(repo.save(art));
    }

    public String eliminaArticulos(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Artículo eliminado correctamente";
        }
        return "Artículo no encontrado con ID: " + id;
    }
}
