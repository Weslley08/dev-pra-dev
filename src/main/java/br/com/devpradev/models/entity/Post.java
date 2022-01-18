package br.com.devpradev.models.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique=true)
  private Long idPost;

  @Column(nullable = false)
  private String titulo;

  @Column(nullable = false)
  private String autor;

  @Column(nullable = false)
  private String texto;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy - HH:mm", timezone = "America/Sao_Paulo")
  private Date data = new Date();

}