package com.kamil.fearlessdailybe.application.domain.service;

import com.kamil.fearlessdailybe.application.domain.model.GymSession;
import com.kamil.fearlessdailybe.application.port.in.GymSessionService;
import com.kamil.fearlessdailybe.application.port.out.GymSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
class GymSessionServiceImpl implements GymSessionService {

    private final GymSessionRepository gymSessionRepository;

    @Override
    public GymSession createGymSession(String gymName, DayOfWeek dayOfWeek) {
        GymSession gymSession = new GymSession(gymName, dayOfWeek);
        return gymSessionRepository.save(gymSession);
    }

    @Override
    public GymSession updateGymSession(UUID id, String gymName, DayOfWeek dayOfWeek) {
        return gymSessionRepository.findById(id)
                .map(existingSession -> {
                    existingSession.setGymName(gymName);
                    existingSession.setDayOfWeek(dayOfWeek);
                    return gymSessionRepository.save(existingSession);
                })
                .orElseThrow(() -> new IllegalArgumentException("Gym session not found with id: " + id));
    }

    @Override
    public void markSessionAsCompleted(UUID id) {
        gymSessionRepository.findById(id)
                .map(session -> {
                    session.setCompleted(true);
                    return gymSessionRepository.save(session);
                })
                .orElseThrow(() -> new IllegalArgumentException("Gym session not found with id: " + id));
    }

    @Override
    public void markSessionAsNotCompleted(UUID id) {
        gymSessionRepository.findById(id)
                .map(session -> {
                    session.setCompleted(false);
                    return gymSessionRepository.save(session);
                })
                .orElseThrow(() -> new IllegalArgumentException("Gym session not found with id: " + id));
    }

    @Override
    public Optional<GymSession> getGymSessionById(UUID id) {
        return gymSessionRepository.findById(id);
    }

    @Override
    public List<GymSession> getAllGymSessions() {
        return gymSessionRepository.findAll();
    }

    @Override
    public List<GymSession> getGymSessionsByDay(DayOfWeek dayOfWeek) {
        return gymSessionRepository.findByDayOfWeek(dayOfWeek);
    }

    @Override
    public List<GymSession> getGymSessionsByGymName(String gymName) {
        return gymSessionRepository.findByGymName(gymName);
    }

    @Override
    public void deleteGymSession(UUID id) {
        gymSessionRepository.deleteById(id);
    }
}