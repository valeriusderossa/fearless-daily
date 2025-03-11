package com.kamil.fearlessdailybe.application.port.out;

import com.kamil.fearlessdailybe.application.domain.model.GymSession;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface GymSessionRepository {
    GymSession save(GymSession gymSession);

    Optional<GymSession> findById(UUID id);

    List<GymSession> findAll();

    List<GymSession> findByDayOfWeek(DayOfWeek dayOfWeek);

    List<GymSession> findByGymName(String gymName);

    void deleteById(UUID id);
}
