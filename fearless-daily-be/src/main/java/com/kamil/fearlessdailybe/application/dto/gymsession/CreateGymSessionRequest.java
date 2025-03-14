package com.kamil.fearlessdailybe.application.dto.gymsession;

import java.time.DayOfWeek;

public record CreateGymSessionRequest(
        String gynName,
        DayOfWeek dayOfWeek
) {
}
