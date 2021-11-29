package br.com.devpradev.post.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    @Column(unique=true)
    private Long idPost;

    @NotBlank(message = "Titulo não deve estar em branco.")
    @Size(min = 20, message = "O titulo deve conter no minimo 20 caracteres")
    private String titulo;

    @NotBlank(message = "Autor não deve estar em branco.")
    @Size(min = 3, max = 32, message = "O Autor deve conter no minimo 3 caracteres e no máximo 32")
    private String autor;

    @NotBlank(message = "Texto não deve estar em branco.")
    @Size(min = 30, message = "O texto deve conter no minimo 30 caracteres")
    private String texto;

    @Builder.Default
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm", timezone = "America/Sao_Paulo")
    private Date data = new Date();

}