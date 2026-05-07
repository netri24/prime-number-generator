package com.example.primenumbergenerator;

import com.example.primenumbergenerator.algorithm.SieveAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SieveAlgorithmTest {

    @Test
    void testPrimeNumbers() {

        SieveAlgorithm sieveAlgorithm = new SieveAlgorithm();

        List<Integer> result = sieveAlgorithm.generatePrimeNumber(1, 10);

        assertEquals(List.of(2, 3, 5, 7), result);
    }

    @Test
    void testNegativeInput() {

        SieveAlgorithm algorithm = new SieveAlgorithm();

        assertThrows(IllegalArgumentException.class,
                () -> algorithm.generatePrimeNumber(-1, 10));
    }

    @Test
    void testInvalidRange() {

        SieveAlgorithm algorithm = new SieveAlgorithm();

        assertThrows(IllegalArgumentException.class,
                () -> algorithm.generatePrimeNumber(20, 10));
    }
}
