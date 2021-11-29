package br.com.devpradev.pessoa.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.devpradev.pessoa.models.enums.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long idPessoa;

    @NotEmpty
    @Size(min = 2, max = 64)
    private String nome;

    @NotEmpty
    @Size(min = 2, max = 64)
    private String sobrenome;

    @CPF
    @NotEmpty
    private String cpf;

    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
    private Date dataDeNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private Telefone telefone;

}
