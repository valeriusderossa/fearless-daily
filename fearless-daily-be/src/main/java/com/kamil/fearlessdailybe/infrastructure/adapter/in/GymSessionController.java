package com.kamil.fearlessdailybe.infrastructure.adapter.in;

import com.kamil.fearlessdailybe.application.domain.dto.CreateGymSessionRequest;
import com.kamil.fearlessdailybe.application.domain.dto.UpdateGymSessionRequest;
import com.kamil.fearlessdailybe.application.domain.model.GymSession;
import com.kamil.fearlessdailybe.application.port.in.GymSessionPersistence;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/gym-sessions")
public class GymSessionController {

    private final GymSessionPersistence gymSessionPersistence;

    public GymSessionController(GymSessionPersistence gymSessionPersistence) {
        this.gymSessionPersistence = gymSessionPersistence;
    }

    @PostMapping
    public ResponseEntity<GymSession> createGymSession(@RequestBody CreateGymSessionRequest request) {
        GymSession created = gymSessionPersistence.createGymSession(
                request.gynName(),
                request.dayOfWeek()
        );
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GymSession> updateGymSession(
            @PathVariable UUID id,
            @RequestBody UpdateGymSessionRequest request) {
        GymSession updated = gymSessionPersistence.updateGymSession(
                id,
                request.gynName(),
                request.dayOfWeek()
        );
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Void> markSessionAsCompleted(@PathVariable UUID id) {
        gymSessionPersistence.markSessionAsCompleted(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/incomplete")
    public ResponseEntity<Void> markSessionAsNotCompleted(@PathVariable UUID id) {
        gymSessionPersistence.markSessionAsNotCompleted(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymSession> getGymSessionById(@PathVariable UUID id) {
        return gymSessionPersistence.getGymSessionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<GymSession>> getAllGymSessions() {
        return ResponseEntity.ok(gymSessionPersistence.getAllGymSessions());
    }

    @GetMapping("/by-day/{dayOfWeek}")
    public ResponseEntity<List<GymSession>> getGymSessionsByDay(
            @PathVariable DayOfWeek dayOfWeek) {
        return ResponseEntity.ok(gymSessionPersistence.getGymSessionsByDay(dayOfWeek));
    }

    @GetMapping("/by-gym")
    public ResponseEntity<List<GymSession>> getGymSessionsByGymName(
            @RequestParam String gymName) {
        return ResponseEntity.ok(gymSessionPersistence.getGymSessionsByGymName(gymName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGymSession(@PathVariable UUID id) {
        gymSessionPersistence.deleteGymSession(id);
        return ResponseEntity.noContent().build();
    }
}