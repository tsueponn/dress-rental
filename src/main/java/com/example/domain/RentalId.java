package com.example.domain;

public record RentalId(String value) {
    public RentalId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or blank");
        }
    }
}
