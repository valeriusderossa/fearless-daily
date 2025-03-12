package com.kamil.fearlessdailybe.infrastructure.adapter.out;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JdbcGameSessionRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<GymSessionEntity> rowMapper = (rs, rowNum) ->
            new GymSessionEntity(
                    UUID.fromString(rs.getString("id")),
                    rs.getString("gym_name"),
                    DayOfWeek.valueOf(rs.getString("day_of_week")),
                    rs.getBoolean("completed")
            );

    public JdbcGameSessionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public GymSessionEntity save(GymSessionEntity entity) {
        String sql = "INSERT INTO gym_sessions (id, gym_name, day_of_week, completed) " +
                "VALUES (?, ?, ?, ?) " +
                "ON CONFLICT (id) DO UPDATE " +
                "SET gym_name = ?, day_of_week = ?, completed = ?";

        jdbcTemplate.update(
                sql,
                entity.id().toString(),
                entity.gymName(),
                entity.dayOfWeek().toString(),
                entity.completed(),
                entity.gymName(),
                entity.dayOfWeek().toString(),
                entity.completed()
        );

        return entity;
    }

    public Optional<GymSessionEntity> findById(UUID id) {
        String sql = "SELECT id, gym_name, day_of_week, completed FROM gym_sessions WHERE id = ?";
        return jdbcTemplate.query(sql, rowMapper, id.toString()).stream().findFirst();
    }

    public List<GymSessionEntity> findAll() {
        String sql = "SELECT id, gym_name, day_of_week, completed FROM gym_sessions";
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<GymSessionEntity> findByDayOfWeek(DayOfWeek dayOfWeek) {
        String sql = "SELECT id, gym_name, day_of_week, completed FROM gym_sessions WHERE day_of_week = ?";
        return jdbcTemplate.query(sql, rowMapper, dayOfWeek.toString());
    }

    public List<GymSessionEntity> findByGymName(String gymName) {
        String sql = "SELECT id, gym_name, day_of_week, completed FROM gym_sessions WHERE gym_name ILIKE ?";
        return jdbcTemplate.query(sql, rowMapper, "%" + gymName + "%");
    }

    public void deleteById(UUID id) {
        String sql = "DELETE FROM gym_sessions WHERE id = ?";
        jdbcTemplate.update(sql, id.toString());
    }
}