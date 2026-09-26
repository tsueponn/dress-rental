package com.example.domain;

public interface RentalRule {
    void validate(RentalStatus from, RentalStatus to);
}
