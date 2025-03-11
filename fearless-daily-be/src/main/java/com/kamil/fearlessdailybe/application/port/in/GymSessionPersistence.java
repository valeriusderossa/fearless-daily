package com.kamil.fearlessdailybe.application.port.in;

import com.kamil.fearlessdailybe.application.domain.model.GymSession;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GymSessionPersistence {

    GymSession createGymSession(String gymName, DayOfWeek dayOfWeek);

    GymSession updateGymSession(UUID id, String gymName, DayOfWeek dayOfWeek);

    void markSessionAsCompleted(UUID id);

    void markSessionAsNotCompleted(UUID id);

    Optional<GymSession> getGymSessionById(UUID id);

    List<GymSession> getAllGymSessions();

    List<GymSession> getGymSessionsByDay(DayOfWeek dayOfWeek);

    List<GymSession> getGymSessionsByGymName(String gymName);

    void deleteGymSession(UUID id);
}
