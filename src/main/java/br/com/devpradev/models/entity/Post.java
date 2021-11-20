package br.com.devpradev.models.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_post", unique=true)
  private Long idPost;

  // * Definir tamanho maximo que o atributo pode receber(50 caracteres)
  @NotEmpty
  private String titulo;

  // * Definir tamanho maximo que o atributo pode receber (50 caracteres)
  @NotEmpty
  private String autor;

  // * Definir tamanho maximo que o atributo pode receber(200 caracteres)
  @NotEmpty
  private String texto;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm", timezone = "America/Sao_Paulo")
  private Date data = new Date();

}