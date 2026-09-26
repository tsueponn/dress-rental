package com.example.domain;

public class StatusTransitionRule implements RentalRule {
    @Override
    public void validate(RentalStatus from, RentalStatus to) {
        if (from == RentalStatus.AVAILABLE && to == RentalStatus.RETURNED) {
            throw new IllegalStateException("Cannot return dress that was never booked.");
        }
    }
}
