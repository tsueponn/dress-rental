package com.example;

import com.example.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RentalPolicyTest {

    private final RentalPolicy policy = new RentalPolicy(List.of(
        new StatusTransitionRule(),
        new StopFactorRule()
    ));

    @ParameterizedTest
    @CsvSource({
        "AVAILABLE, BOOKED, true",
        "BOOKED, RETURNED, true",
        "AVAILABLE, RETURNED, false",
        "BOOKED, AVAILABLE, false"
    })
    void testStatusTransitions(RentalStatus from, RentalStatus to, boolean allowed) {
        if (allowed) {
            RentalStatus result = policy.move(from, to);
            assertEquals(to, result);
        } else {
            assertThrows(IllegalStateException.class, () -> policy.move(from, to));
        }
    }

    @Test
    void testInvalidIdThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new RentalId(null));
        assertThrows(IllegalArgumentException.class, () -> new RentalId("  "));
    }
}
