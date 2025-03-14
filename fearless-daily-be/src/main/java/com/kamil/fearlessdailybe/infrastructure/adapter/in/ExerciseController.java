package com.kamil.fearlessdailybe.infrastructure.adapter.in;

import com.kamil.fearlessdailybe.application.dto.exercise.CreateExerciseRequest;
import com.kamil.fearlessdailybe.application.dto.exercise.UpdateExerciseRequest;
import com.kamil.fearlessdailybe.application.port.in.ExerciseService;
import com.kamil.fearlessdailybe.domain.model.Exercise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;


    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody CreateExerciseRequest request) {
        Exercise created = exerciseService.createExercise(
                request.name(),
                request.notes()
        );
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercise> updateExercise(
            @PathVariable UUID id,
            @RequestBody UpdateExerciseRequest request) {
        Exercise updated = exerciseService.updateExercise(
                id,
                request.name(),
                request.notes()
        );
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable UUID id) {
        return exerciseService.getExerciseId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises() {
        return ResponseEntity.ok(exerciseService.getAllExercise());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercise(@PathVariable UUID id) {
        exerciseService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }
}