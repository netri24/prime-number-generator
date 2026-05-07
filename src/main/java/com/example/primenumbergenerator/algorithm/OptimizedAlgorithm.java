package com.example.primenumbergenerator.algorithm;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OptimizedAlgorithm implements PrimeGenerator {

    @Override
    public List<Integer> generatePrimeNumber(int start, int end) {

        if (start < 0 || end < 0) {
            throw new IllegalArgumentException("Negative numbers not allowed");
        }

        if (start >= end) {
            throw new IllegalArgumentException("Start number must be smaller than end number");
        }
        //store prime numbers
        List<Integer> primes = new ArrayList<>();

        for (int num = start; num <= end; num++) {

            //skip number 2 (not prime number )
            if (num < 2)
                continue;

            if (num == 2) {
                primes.add(2);
                continue;
            }

            //skip all other even number
            if (num % 2 == 0) {
                continue;
            }

            // assume number is prime
            boolean isPrime = true;

            //check if number is divisible by an odd number
            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            // prime number add to list
            if (isPrime) {
                primes.add(num);
            }
        }

        return primes;
    }

}
