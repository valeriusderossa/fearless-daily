package com.kamil.fearlessdailybe.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Exercise {

    private final UUID id;
    private UUID gymSessionId;
    private String name;
    private String notes;
    private List<ExerciseSet> exerciseSets;
}
