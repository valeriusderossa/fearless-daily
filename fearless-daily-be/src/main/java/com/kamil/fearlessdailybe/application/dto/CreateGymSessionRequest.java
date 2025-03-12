package com.kamil.fearlessdailybe.application.dto;

import java.time.DayOfWeek;

public record CreateGymSessionRequest(
        String gynName,
        DayOfWeek dayOfWeek
) {
}
