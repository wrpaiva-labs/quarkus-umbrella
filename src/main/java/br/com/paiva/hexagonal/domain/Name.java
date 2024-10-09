package br.com.paiva.hexagonal.domain;

import br.com.paiva.hexagonal.exceptions.ValidationException;

public record Name(String value) {
    public Name {
        if (value == null || value.isBlank()) {
            throw new ValidationException("Name is required");
        }
    }
}
