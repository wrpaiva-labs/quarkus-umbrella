package br.com.paiva.hexagonal.domain;

import br.com.paiva.hexagonal.exceptions.ValidationException;

public record Description(String value) {

    public Description {
        if (value == null || value.isBlank()) {
            throw new ValidationException("Description is required");
        }
    }
}
