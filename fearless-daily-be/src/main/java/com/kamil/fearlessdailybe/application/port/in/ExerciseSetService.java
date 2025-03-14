package com.kamil.fearlessdailybe.application.port.in;

import com.kamil.fearlessdailybe.domain.model.ExerciseSet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseSetService {

    ExerciseSet createExerciseSet(UUID exerciseId, int reps, double weight);

    ExerciseSet updateExerciseSet(UUID id, UUID exerciseId, int reps, double weight);

    Optional<ExerciseSet> getExerciseSetId(UUID id);

    List<ExerciseSet> getAllExerciseSet();

    void deleteExercise(UUID id);
}