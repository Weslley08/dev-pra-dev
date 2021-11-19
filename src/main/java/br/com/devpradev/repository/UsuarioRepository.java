package br.com.devpradev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devpradev.models.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByLogin(String login);

}
