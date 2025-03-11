package com.kamil.fearlessdailybe.infrastructure.adapter.out;

import com.kamil.fearlessdailybe.application.domain.model.GymSession;
import com.kamil.fearlessdailybe.application.port.out.GymSessionRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Primary
public class GymSessionRepositoryImpl implements GymSessionRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<GymSession> rowMapper = (rs, rowNum) ->
            new GymSession(
                    UUID.fromString(rs.getString("id")),
                    rs.getString("gym_name"),
                    DayOfWeek.valueOf(rs.getString("day_of_week")),
                    rs.getBoolean("completed")
            );

    public GymSessionRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public GymSession save(GymSession gymSession) {
        String sql = "INSERT INTO gym_sessions (id, gym_name, day_of_week, completed) " +
                "VALUES (?, ?, ?, ?) " +
                "ON CONFLICT (id) DO UPDATE " +
                "SET gym_name = ?, day_of_week = ?, completed = ?";

        jdbcTemplate.update(
                sql,
                gymSession.getId().toString(),
                gymSession.getGymName(),
                gymSession.getDayOfWeek().toString(),
                gymSession.isCompleted(),
                gymSession.getGymName(),
                gymSession.getDayOfWeek().toString(),
                gymSession.isCompleted()
        );

        return gymSession;
    }

    @Override
    public Optional<GymSession> findById(UUID id) {
        String sql = "SELECT id, gym_name, day_of_week, completed FROM gym_sessions WHERE id = ?";

        List<GymSession> results = jdbcTemplate.query(
                sql,
                rowMapper,
                id.toString()
        );

        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    @Override
    public List<GymSession> findAll() {
        String sql = "SELECT id, gym_name, day_of_week, completed FROM gym_sessions";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<GymSession> findByDayOfWeek(DayOfWeek dayOfWeek) {
        String sql = "SELECT id, gym_name, day_of_week, completed FROM gym_sessions WHERE day_of_week = ?";
        return jdbcTemplate.query(sql, rowMapper, dayOfWeek.toString());
    }

    @Override
    public List<GymSession> findByGymName(String gymName) {
        String sql = "SELECT id, gym_name, day_of_week, completed FROM gym_sessions WHERE gym_name ILIKE ?";
        return jdbcTemplate.query(sql, rowMapper, "%" + gymName + "%");
    }

    @Override
    public void deleteById(UUID id) {
        String sql = "DELETE FROM gym_sessions WHERE id = ?";
        jdbcTemplate.update(sql, id.toString());
    }
}