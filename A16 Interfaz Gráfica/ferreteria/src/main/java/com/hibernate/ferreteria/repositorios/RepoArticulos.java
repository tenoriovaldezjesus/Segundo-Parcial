package com.hibernate.ferreteria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hibernate.ferreteria.entity.Articulos;

public interface RepoArticulos extends JpaRepository<Articulos, Long> {
}
