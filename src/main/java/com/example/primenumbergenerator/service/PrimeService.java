package com.example.primenumbergenerator.service;

import com.example.primenumbergenerator.entity.PrimeExecution;
import com.example.primenumbergenerator.repository.PrimeExecutionRepository;
import com.example.primenumbergenerator.algorithm.OptimizedAlgorithm;
import com.example.primenumbergenerator.algorithm.PrimeGenerator;
import com.example.primenumbergenerator.algorithm.SieveAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PrimeService {

    // Optimized prime algorithm
    @Autowired
    private OptimizedAlgorithm optimizedAlgorithm;

    // Sieve prime algorithm
    @Autowired
    private SieveAlgorithm sieveAlgorithm;

    // Database repository
    @Autowired
    private PrimeExecutionRepository primeExecutionRepository;

    public List<Integer> generate(int start, int end, String algorithm) {

        // Start execution time
        long startTime = System.currentTimeMillis();

        List<Integer> primes;

        // Select algorithm
        if (algorithm.equalsIgnoreCase("sieve")) {
            primes = sieveAlgorithm.generatePrimeNumber(start, end);

        } else {
            primes = optimizedAlgorithm.generatePrimeNumber(start, end);
        }

        // End execution time
        long endTime = System.currentTimeMillis();

        // Create execution log object
        PrimeExecution log = new PrimeExecution();

        log.setStartRange(start);
        log.setEndRange(end);
        log.setAlgorithm(algorithm);
        log.setResultCount(primes.size());

        // Total execution time
        log.setTimeTaken(endTime - startTime);

        // Current timestamp
        log.setTimestamp(LocalDateTime.now());

        // Save into database
        primeExecutionRepository.save(log);

        // Return prime numbers
        return primes;
    }
}

