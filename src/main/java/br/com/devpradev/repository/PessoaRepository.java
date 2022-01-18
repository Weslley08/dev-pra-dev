package br.com.devpradev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devpradev.models.entity.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
