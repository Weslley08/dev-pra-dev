package br.com.devpradev.pessoa.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import br.com.devpradev.pessoa.models.dto.PessoaDTO;
import br.com.devpradev.pessoa.models.entity.Pessoa;

@Mapper
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    Pessoa toModel(PessoaDTO pessoaDTO);
    PessoaDTO toDTO(Pessoa pessoa);

}
