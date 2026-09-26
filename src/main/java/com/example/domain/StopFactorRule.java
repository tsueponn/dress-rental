package com.example.domain;

public class StopFactorRule implements RentalRule {
    @Override
    public void validate(RentalStatus from, RentalStatus to) {
        if (from == RentalStatus.BOOKED && to == RentalStatus.AVAILABLE) {
            throw new IllegalStateException("Booked dress cannot go straight to Available. Must be Returned first.");
        }
    }
}
