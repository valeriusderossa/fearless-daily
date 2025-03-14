package com.kamil.fearlessdailybe.domain.service;

import com.kamil.fearlessdailybe.application.port.out.ExerciseSetRepository;
import com.kamil.fearlessdailybe.domain.model.ExerciseSet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ExerciseServiceSetImpl implements ExerciseSetRepository {
    @Override
    public ExerciseSet save(ExerciseSet exerciseSet) {
        return null;
    }

    @Override
    public Optional<ExerciseSet> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<ExerciseSet> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(UUID id) {

    }
}
