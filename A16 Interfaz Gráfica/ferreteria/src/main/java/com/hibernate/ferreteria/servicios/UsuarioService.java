package com.hibernate.ferreteria.servicios;

import java.util.Collections;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.hibernate.ferreteria.entity.Usuario;
import com.hibernate.ferreteria.repositorios.RepoUsuarios;

@Service
public class UsuarioService implements UserDetailsService {

    private final RepoUsuarios repoUsuarios;

    public UsuarioService(RepoUsuarios repoUsuarios) {
        this.repoUsuarios = repoUsuarios;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repoUsuarios.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
        return new User(
                user.getUsuario(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRol()))
        );
    }
}
