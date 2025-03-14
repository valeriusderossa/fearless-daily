package com.kamil.fearlessdailybe.infrastructure.adapter.out.gymsession;

import java.time.DayOfWeek;
import java.util.UUID;

public record GymSessionEntity(
        UUID id,
        String gymName,
        DayOfWeek dayOfWeek,
        boolean completed
) {
}