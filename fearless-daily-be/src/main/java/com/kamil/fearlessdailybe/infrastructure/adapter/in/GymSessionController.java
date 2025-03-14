package com.kamil.fearlessdailybe.infrastructure.adapter.in;

import com.kamil.fearlessdailybe.application.dto.gymsession.CreateGymSessionRequest;
import com.kamil.fearlessdailybe.application.dto.gymsession.UpdateGymSessionRequest;
import com.kamil.fearlessdailybe.domain.model.GymSession;
import com.kamil.fearlessdailybe.application.port.in.GymSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/gym-sessions")
public class GymSessionController {

    private final GymSessionService gymSessionService;

    public GymSessionController(GymSessionService gymSessionService) {
        this.gymSessionService = gymSessionService;
    }

    @PostMapping
    public ResponseEntity<GymSession> createGymSession(@RequestBody CreateGymSessionRequest request) {
        GymSession created = gymSessionService.createGymSession(
                request.gynName(),
                request.dayOfWeek()
        );
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GymSession> updateGymSession(
            @PathVariable UUID id,
            @RequestBody UpdateGymSessionRequest request) {
        GymSession updated = gymSessionService.updateGymSession(
                id,
                request.gynName(),
                request.dayOfWeek()
        );
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}/complete")
    public ResponseEntity<Void> markSessionAsCompleted(@PathVariable UUID id) {
        gymSessionService.markSessionAsCompleted(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/incomplete")
    public ResponseEntity<Void> markSessionAsNotCompleted(@PathVariable UUID id) {
        gymSessionService.markSessionAsNotCompleted(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GymSession> getGymSessionById(@PathVariable UUID id) {
        return gymSessionService.getGymSessionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<GymSession>> getAllGymSessions() {
        return ResponseEntity.ok(gymSessionService.getAllGymSessions());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGymSession(@PathVariable UUID id) {
        gymSessionService.deleteGymSession(id);
        return ResponseEntity.noContent().build();
    }
}