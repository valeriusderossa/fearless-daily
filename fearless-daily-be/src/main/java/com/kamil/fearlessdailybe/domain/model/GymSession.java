package com.kamil.fearlessdailybe.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
public class GymSession {
    private final UUID id;
    private String gymName;
    private DayOfWeek dayOfWeek;
    private boolean completed;
    private List<Exercise> exercises;


    public GymSession(String gymName, DayOfWeek dayOfWeek) {
        this.id = UUID.randomUUID();
        this.gymName = gymName;
        this.dayOfWeek = dayOfWeek;
        this.completed = false;
    }

    public GymSession(UUID id, String gymName, DayOfWeek dayOfWeek, boolean completed) {
        this.id = id;
        this.gymName = gymName;
        this.dayOfWeek = dayOfWeek;
        this.completed = completed;
    }

    public static GymSession withId(
            UUID id,
            String gymName,
            DayOfWeek dayOfWeek,
            boolean completed) {
        return new GymSession(id, gymName, dayOfWeek, completed);
    }

}