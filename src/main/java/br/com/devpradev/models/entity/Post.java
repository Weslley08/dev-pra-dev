package br.com.devpradev.models.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_post")
  private Long idPost;

  @NotEmpty
  @Size(min = 5, message = "O título não pode ter menos que 5 caracteres!")
  private String titulo;

  @NotEmpty
  @Size(min = 5, message = "O título não pode ter menos que 5 caracteres!")
  private String autor;

  @NotEmpty
  @Size(min = 10, message = "O conteúdo não pode ter menos que 10 caracteres!")
  private String texto;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy HH:mm:ss a z", timezone = "America/Sao_Paulo")
  private Date data = new Date();

}