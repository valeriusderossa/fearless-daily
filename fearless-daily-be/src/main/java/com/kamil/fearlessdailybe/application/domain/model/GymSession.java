package com.kamil.fearlessdailybe.application.domain.model;

import java.time.DayOfWeek;
import java.util.Objects;
import java.util.UUID;

/**
 * Entity representing a gym session.
 */
public class GymSession {
    private final UUID id;
    private String gymName;
    private DayOfWeek dayOfWeek;
    private boolean completed;

    /**
     * Creates a new gym session with a random ID.
     */
    public GymSession(String gymName, DayOfWeek dayOfWeek) {
        this.id = UUID.randomUUID();
        this.gymName = gymName;
        this.dayOfWeek = dayOfWeek;
        this.completed = false;
    }

    /**
     * Creates a gym session with a specified ID.
     */
    public GymSession(UUID id, String gymName, DayOfWeek dayOfWeek, boolean completed) {
        this.id = id;
        this.gymName = gymName;
        this.dayOfWeek = dayOfWeek;
        this.completed = completed;
    }

    public UUID getId() {
        return id;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GymSession that = (GymSession) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GymSession{" +
                "id=" + id +
                ", gymName='" + gymName + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", completed=" + completed +
                '}';
    }
}