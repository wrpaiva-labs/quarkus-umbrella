package br.com.paiva.hexagonal.application.domain.model;

import br.com.paiva.hexagonal.application.exceptions.ValidationException;

import java.util.UUID;

public record ServiceId(String value) {

    public ServiceId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Invalid value for ServiceId");
        }
    }

    public static ServiceId unique() {
        return new ServiceId(UUID.randomUUID().toString());
    }

    public static ServiceId with(String value) {
       try {
           return new ServiceId(UUID.fromString(value).toString());
       } catch (IllegalArgumentException e) {
           throw new ValidationException("Invalid value for ServiceId");
       }
    }
}
