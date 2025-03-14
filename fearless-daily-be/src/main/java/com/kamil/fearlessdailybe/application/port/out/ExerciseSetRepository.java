package com.kamil.fearlessdailybe.application.port.out;

import com.kamil.fearlessdailybe.domain.model.ExerciseSet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExerciseSetRepository {

    ExerciseSet save(ExerciseSet exerciseSet);

    Optional<ExerciseSet> findById(UUID id);

    List<ExerciseSet> findAll();

    void deleteById(UUID id);
}
