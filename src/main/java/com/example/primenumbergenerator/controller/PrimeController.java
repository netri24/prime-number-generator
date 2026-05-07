package com.example.primenumbergenerator.controller;

import com.example.primenumbergenerator.service.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/primes")
public class PrimeController {

    @Autowired
    private PrimeService primeService;

    @GetMapping
    public List<Integer> getPrimes(
            @RequestParam int start,
            @RequestParam int end,
            @RequestParam(defaultValue = "optimized") String strategy) {

        if (start > end) {
            throw new RuntimeException("Invalid range");
        }

        return primeService.generate(start, end, strategy);
    }
}

