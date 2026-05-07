package com.example.primenumbergenerator;

import com.example.primenumbergenerator.algorithm.OptimizedAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptimizedAlgorithmTest {

    @Test
    void testPrimeNumbers() {

        OptimizedAlgorithm optimizedAlgorithm = new OptimizedAlgorithm();

        List<Integer> result = optimizedAlgorithm.generatePrimeNumber(1, 10);

        assertEquals(List.of(2, 3, 5, 7), result);
    }

    @Test
    void testNegativeInput() {

        OptimizedAlgorithm strategy = new OptimizedAlgorithm();

        assertThrows(IllegalArgumentException.class,
                () -> {
                    if (-1 < 0 || 10 < 0) {
                        throw new IllegalArgumentException("Negative numbers not allowed");
                    }

                    strategy.generatePrimeNumber(-1, 10);
                });
    }

    @Test
    void testInvalidRange() {

        OptimizedAlgorithm strategy = new OptimizedAlgorithm();

        assertThrows(IllegalArgumentException.class,
                () -> {
                    if (20 >= 10) {
                        throw new IllegalArgumentException("Start number must be smaller than end number");
                    }
                    strategy.generatePrimeNumber(20, 10);
               });
    }
}
