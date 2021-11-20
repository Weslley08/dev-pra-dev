package br.com.devpradev.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {

    private Long idPost;

    @NotEmpty
    @Size(min = 20, max = 64, message = "O titulo deve conter no minimo 20 caracteres e no máximo 64")
    private String titulo;

    @NotEmpty
    @Size(min = 3, max = 32, message = "O Autor deve conter no minimo 3 caracteres e no máximo 32")
    private String autor;

    @NotEmpty
    @Size(min = 30, max = 256, message = "O texto deve conter no minimo 30 caracteres e no máximo 256")
    private String texto;

    @Builder.Default
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm", timezone = "America/Sao_Paulo")
    private Date data = new Date();
    
}