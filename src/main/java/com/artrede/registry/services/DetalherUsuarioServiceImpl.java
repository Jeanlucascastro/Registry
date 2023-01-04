package com.artrede.registry.services;

import com.artrede.registry.data.DetalheUsuarioData;
import com.artrede.registry.entities.Usuario;
import com.artrede.registry.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalherUsuarioServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public DetalherUsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByUserName(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }

        return new DetalheUsuarioData(usuario);
    }
}
