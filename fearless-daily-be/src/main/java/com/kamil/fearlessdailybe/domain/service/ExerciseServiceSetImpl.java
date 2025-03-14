package com.kamil.fearlessdailybe.domain.service;

import com.kamil.fearlessdailybe.application.port.in.ExerciseSetService;
import com.kamil.fearlessdailybe.domain.model.ExerciseSet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExerciseServiceSetImpl implements ExerciseSetService {

    @Override
    public ExerciseSet createExerciseSet(UUID exerciseId, int reps, double weight) {
        return null;
    }

    @Override
    public ExerciseSet updateExerciseSet(UUID id, UUID exerciseId, int reps, double weight) {
        return null;
    }

    @Override
    public Optional<ExerciseSet> getExerciseSetId(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<ExerciseSet> getAllExerciseSet() {
        return List.of();
    }

    @Override
    public void deleteExercise(UUID id) {

    }
}
