package com.kamil.fearlessdailybe.infrastructure.adapter.out.exercise;

import com.kamil.fearlessdailybe.application.port.out.ExerciseRepository;
import com.kamil.fearlessdailybe.domain.model.Exercise;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ExerciseRepositoryImpl implements ExerciseRepository {

    @Override
    public Exercise save(Exercise exercise) {
        return null;
    }

    @Override
    public Optional<Exercise> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Exercise> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {

    }
}
