package com.kamil.fearlessdailybe.application.port.in;

import com.kamil.fearlessdailybe.domain.model.Exercise;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseService {

    Exercise createExercise(String gymName, DayOfWeek dayOfWeek);

    Exercise updateExercise(UUID id, String gymName, DayOfWeek dayOfWeek);

    Optional<Exercise> getExerciseId(UUID id);

    List<Exercise> getAllExercise();

    void deleteExercise(UUID id);
}
