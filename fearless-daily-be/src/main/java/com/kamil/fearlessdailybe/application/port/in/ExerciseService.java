package com.kamil.fearlessdailybe.application.port.in;

import com.kamil.fearlessdailybe.domain.model.Exercise;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseService {

    Exercise createExercise(String name, String notes);

    Exercise updateExercise(UUID id, String name, String notes);

    Optional<Exercise> getExerciseId(UUID id);

    List<Exercise> getAllExercise();

    void deleteExercise(UUID id);
}
