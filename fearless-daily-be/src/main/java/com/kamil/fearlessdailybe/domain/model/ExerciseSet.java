package com.kamil.fearlessdailybe.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ExerciseSet {

    private final UUID id;
    private UUID exerciseId;
    private int reps;
    private double weight;
}
