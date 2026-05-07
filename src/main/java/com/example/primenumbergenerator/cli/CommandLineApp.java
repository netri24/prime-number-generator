package com.example.primenumbergenerator.cli;

import com.example.primenumbergenerator.algorithm.OptimizedAlgorithm;
import com.example.primenumbergenerator.algorithm.PrimeGenerator;
import com.example.primenumbergenerator.algorithm.SieveAlgorithm;

import java.util.*;

public class CommandLineApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter start number: ");
        int start = sc.nextInt();

        System.out.print("Enter end number: ");
        int end = sc.nextInt();

        // Validation
        if (start < 0 || end < 0) {
            System.out.println("Negative numbers are not allowed.");
            return;
        }

        if (start >= end) {
            System.out.println("End number must be greater than start number.");
            return;
        }

        // Algorithm selection
        System.out.println("\nChoose Prime Number Algorithm:");
        System.out.println("A. Optimized Strategy");
        System.out.println("B. Sieve Strategy");

        System.out.print("Enter choice (A or B): ");
        String choice = sc.next();

        PrimeGenerator strategy;

        switch (choice.toUpperCase()) {
            case "A":
                strategy = new OptimizedAlgorithm();
                break;

            case "B":
                strategy = new SieveAlgorithm();
                break;

            default:
                System.out.println("Invalid algorithm choice.");
                return;
        }

        // Generate primes
        List<Integer> primes = strategy.generatePrimeNumber(start, end);

        // Output
        System.out.println("\nPrime Numbers:");
        System.out.println(primes);
    }
}
