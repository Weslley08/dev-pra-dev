package br.com.devpradev.models.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PostDTO {

    private Long idPost;

    @NotEmpty
    @Size(min = 20, max = 64)
    private String titulo;

    @NotEmpty
    @Size(min = 2, max = 32)
    private String autor;

    @NotEmpty
    @Size(min = 30, max = 256)
    private String texto;

    private Date data = new Date();
    
}