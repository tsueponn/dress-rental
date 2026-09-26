package com.example.config;

import com.example.domain.RentalPolicy;
import com.example.domain.RentalStatus;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    private final RentalPolicy rentalPolicy;

    public RentalService(RentalPolicy rentalPolicy) {
        this.rentalPolicy = rentalPolicy;
    }

    public RentalStatus move(RentalStatus from, RentalStatus to) {
        return rentalPolicy.move(from, to);
    }
}
