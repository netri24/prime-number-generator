package com.example.primenumbergenerator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class PrimeExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int startRange;
    private int endRange;

    private String algorithm;
    private long timeTaken;
    private int resultCount;

    private LocalDateTime timestamp;

}
