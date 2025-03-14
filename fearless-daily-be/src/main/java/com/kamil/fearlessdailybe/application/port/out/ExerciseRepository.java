package com.kamil.fearlessdailybe.application.port.out;

import com.kamil.fearlessdailybe.domain.model.Exercise;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseRepository {

    Exercise save(Exercise exercise);

    Optional<Exercise> findById(UUID id);

    List<Exercise> findAll();

    void deleteById(UUID id);
}
