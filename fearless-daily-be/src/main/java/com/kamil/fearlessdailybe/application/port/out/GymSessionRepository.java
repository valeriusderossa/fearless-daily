package com.kamil.fearlessdailybe.application.port.out;

import com.kamil.fearlessdailybe.domain.model.GymSession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface GymSessionRepository {

    GymSession save(GymSession gymSession);

    Optional<GymSession> findById(UUID id);

    List<GymSession> findAll();

    void deleteById(UUID id);
}
