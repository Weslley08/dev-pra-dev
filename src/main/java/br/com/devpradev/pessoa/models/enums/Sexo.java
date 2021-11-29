package br.com.devpradev.pessoa.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Sexo {

    FEMININO("Feminino"),
    MASCULINO("Masculino"),
    OUTROS("Outros");

    private final String description;

}
