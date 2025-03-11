package com.kamil.fearlessdailybe.application.domain.dto;

import java.time.DayOfWeek;

public record UpdateGymSessionRequest(
        String gynName,
        DayOfWeek dayOfWeek
) {
}
