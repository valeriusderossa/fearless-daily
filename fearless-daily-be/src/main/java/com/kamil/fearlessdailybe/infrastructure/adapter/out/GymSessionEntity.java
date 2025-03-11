package com.kamil.fearlessdailybe.infrastructure.adapter.out;

import java.time.DayOfWeek;
import java.util.UUID;

record GymSessionEntity(
        UUID id,
        String gymName,
        DayOfWeek dayOfWeek,
        boolean completed
) {}