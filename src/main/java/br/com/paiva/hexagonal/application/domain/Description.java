package br.com.paiva.hexagonal.application.domain;

import br.com.paiva.hexagonal.application.exceptions.ValidationException;

public record Description(String value) {

    public Description {
        if (value == null || value.isBlank()) {
            throw new ValidationException("Description is required");
        }
    }
}
