package com.hibernate.ferreteria.repositorios;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hibernate.ferreteria.entity.Usuario;

public interface RepoUsuarios extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String usuario);
}
