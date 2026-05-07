package com.example.primenumbergenerator.algorithm;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SieveAlgorithm implements PrimeGenerator {

    @Override
    public List<Integer> generatePrimeNumber(int start, int end) {

        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("Negative numbers not allowed");
        }

        if (start >= end) {
            throw new IllegalArgumentException("Start number must be smaller than end number");
        }
        // Assume all numbers are prime
        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);

        // 0 and 1 are not prime
        isPrime[0] = false;
        isPrime[1] = false;

        // Remove multiples
        for (int i = 2; i * i <= end; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= end; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Store prime numbers
        List<Integer> primes = new ArrayList<>();

        for (int i = start; i <= end; i++) {

            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

}

