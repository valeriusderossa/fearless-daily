package com.kamil.fearlessdailybe.domain.service;

import com.kamil.fearlessdailybe.application.port.in.ExerciseService;
import com.kamil.fearlessdailybe.domain.model.Exercise;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Override
    public Exercise createExercise(String name, String notes) {
        return null;
    }

    @Override
    public Exercise updateExercise(UUID id, String name, String notes) {
        return null;
    }

    @Override
    public Optional<Exercise> getExerciseId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Exercise> getAllExercise() {
        return List.of();
    }

    @Override
    public void deleteExercise(UUID id) {

    }
}
