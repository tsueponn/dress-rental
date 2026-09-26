package com.example.domain;

import java.util.List;

public class RentalPolicy {
    private final List<RentalRule> rules;

    public RentalPolicy(List<RentalRule> rules) {
        this.rules = rules;
    }

    public RentalStatus move(RentalStatus from, RentalStatus to) {
        for (RentalRule rule : rules) {
            rule.validate(from, to);
        }
        return to;
    }
}
