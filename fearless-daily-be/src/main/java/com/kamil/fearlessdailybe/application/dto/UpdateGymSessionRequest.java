package com.kamil.fearlessdailybe.application.dto;

import java.time.DayOfWeek;

public record UpdateGymSessionRequest(
        String gynName,
        DayOfWeek dayOfWeek
) {
}
