package com.kamil.fearlessdailybe.infrastructure.adapter.in;

import com.kamil.fearlessdailybe.application.port.in.ExerciseSetService;
import com.kamil.fearlessdailybe.domain.model.ExerciseSet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercise-sets")
@RequiredArgsConstructor
public class ExerciseSetController {

    private final ExerciseSetService exerciseSetService;

    @PostMapping
    public ResponseEntity<ExerciseSet> createExerciseSet(@RequestBody CreateExerciseSetRequest request) {
        ExerciseSet created = exerciseSetService.createExerciseSet(
                request.exerciseId(),
                request.reps(),
                request.weight()
        );
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExerciseSet> updateExerciseSet(
            @PathVariable UUID id,
            @RequestBody UpdateExerciseSetRequest request) {
        ExerciseSet updated = exerciseSetService.updateExerciseSet(
                id,
                request.exerciseId(),
                request.reps(),
                request.weight()
        );
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseSet> getExerciseSetById(@PathVariable UUID id) {
        return exerciseSetService.getExerciseSetId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ExerciseSet>> getAllExerciseSets() {
        return ResponseEntity.ok(exerciseSetService.getAllExerciseSet());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExerciseSet(@PathVariable UUID id) {
        exerciseSetService.deleteExercise(id);
        return ResponseEntity.noContent().build();
    }

    public record CreateExerciseSetRequest(
            UUID exerciseId,
            int reps,
            double weight
    ) {
    }

    public record UpdateExerciseSetRequest(
            UUID exerciseId,
            int reps,
            double weight
    ) {
    }
}