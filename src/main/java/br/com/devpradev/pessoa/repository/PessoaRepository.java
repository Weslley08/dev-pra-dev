package br.com.devpradev.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devpradev.pessoa.models.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
