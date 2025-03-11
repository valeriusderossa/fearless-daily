package com.kamil.fearlessdailybe.application.domain.dto;

import java.time.DayOfWeek;

public record CreateGymSessionRequest(
        String gynName,
        DayOfWeek dayOfWeek
) {
}
