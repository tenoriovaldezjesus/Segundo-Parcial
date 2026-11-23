package com.hibernate.ferreteria.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hibernate.ferreteria.dto.ArticulosDTO;
import com.hibernate.ferreteria.servicios.ArticuloService;

@RestController
@RequestMapping("/api/articulos")
@CrossOrigin(origins = "*")
public class ArticuloController {

    @Autowired
    private ArticuloService servicio;

    @GetMapping
    public List<ArticulosDTO> listar() {
        return servicio.servConsulta();
    }

    @GetMapping("/{id}")
    public ArticulosDTO buscarPorId(@PathVariable Long id) {
        return servicio.servBuscaId(id);
    }

    @PostMapping
    public ArticulosDTO insertaArticulo(@RequestBody ArticulosDTO dto) {
        return servicio.servInserta(dto);
    }

    @PutMapping("/{id}")
    public ArticulosDTO actualizaArticulo(@PathVariable Long id, @RequestBody ArticulosDTO dto) {
        return servicio.servActualiza(id, dto);
    }

    @DeleteMapping("/{id}")
    public String borraArticulos(@PathVariable Long id) {
        return servicio.eliminaArticulos(id);
    }
}
