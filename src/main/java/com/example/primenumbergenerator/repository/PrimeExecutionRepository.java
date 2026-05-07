package com.example.primenumbergenerator.repository;

import com.example.primenumbergenerator.entity.PrimeExecution;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrimeExecutionRepository
        extends JpaRepository<PrimeExecution, Long> {
}
