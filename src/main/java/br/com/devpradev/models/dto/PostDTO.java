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

    @Builder.Default
    private Date data = new Date();
    
}