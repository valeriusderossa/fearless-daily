package com.kamil.fearlessdailybe.infrastructure.adapter.out;

import com.kamil.fearlessdailybe.application.domain.model.GymSession;
import org.springframework.stereotype.Component;

@Component
public class GymSessionMapper {

    public GymSessionEntity toEntity(GymSession domain) {
        return new GymSessionEntity(
                domain.getId(),
                domain.getGymName(),
                domain.getDayOfWeek(),
                domain.isCompleted()
        );
    }

    public GymSession toDomain(GymSessionEntity entity) {
        return new GymSession(
                entity.id(),
                entity.gymName(),
                entity.dayOfWeek(),
                entity.completed()
        );
    }
}