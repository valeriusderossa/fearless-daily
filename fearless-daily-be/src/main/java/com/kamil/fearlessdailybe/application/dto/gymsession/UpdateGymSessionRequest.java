package com.kamil.fearlessdailybe.application.dto.gymsession;

import java.time.DayOfWeek;

public record UpdateGymSessionRequest(
        String gynName,
        DayOfWeek dayOfWeek
) {
}
