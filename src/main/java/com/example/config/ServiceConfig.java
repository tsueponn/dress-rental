package com.example.config;

import com.example.domain.RentalPolicy;
import com.example.domain.RentalRule;
import com.example.domain.StatusTransitionRule;
import com.example.domain.StopFactorRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ServiceConfig {

    @Bean
    public RentalPolicy rentalPolicy() {
        List<RentalRule> rules = List.of(
            new StatusTransitionRule(),
            new StopFactorRule()
        );
        return new RentalPolicy(rules);
    }
}
