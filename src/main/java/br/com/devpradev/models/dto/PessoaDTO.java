package br.com.devpradev.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long idPessoa;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String nome;

    @NotEmpty
    @Size(min = 3, max = 20)
    private String sobrenome;
    
    private Date dataDeNascimento;

    @NotEmpty
    private String sexo;

    @NotEmpty
    private String telefone;

}
