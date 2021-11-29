package br.com.devpradev.pessoa.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Telefone {

    NUMERO("numero"),
    NUMERO_ALTERNATIVO("numero_alternativo");

    private final String description;
}
