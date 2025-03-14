package com.kamil.fearlessdailybe.application.port.in;

import com.kamil.fearlessdailybe.domain.model.ExerciseSet;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseSetService {

    ExerciseSet createExerciseSet(String gymName, DayOfWeek dayOfWeek);

    ExerciseSet updateExerciseSet(UUID id, String gymName, DayOfWeek dayOfWeek);

    Optional<ExerciseSet> getExerciseSetId(UUID id);

    List<ExerciseSet> getAllExerciseSet();

    void deleteExercise(UUID id);

}
