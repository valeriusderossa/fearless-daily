package com.kamil.fearlessdailybe.infrastructure.adapter.out.gymsession;

import com.kamil.fearlessdailybe.domain.model.GymSession;
import com.kamil.fearlessdailybe.application.port.out.GymSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class GymSessionRepositoryImpl implements GymSessionRepository {

    private final JdbcTemplate jdbcTemplate;

    private final GymSessionMapper gymSessionMapper;

    private final RowMapper<GymSessionEntity> rowMapper = (rs, rowNum) ->
            new GymSessionEntity(
                    UUID.fromString(rs.getString("id")),
                    rs.getString("gym_name"),
                    DayOfWeek.valueOf(rs.getString("day_of_week")),
                    rs.getBoolean("completed")
            );

    @Override
    public GymSession save(GymSession gymSession) {
        GymSessionEntity entity = gymSessionMapper.toEntity(gymSession);

        String sql = "INSERT INTO gym_sessions (id, gym_name, day_of_week, completed) " +
                "VALUES (CAST(? AS UUID), ?, ?, ?) " +
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

        return gymSession;
    }

    @Override
    public Optional<GymSession> findById(UUID id) {
        String sql = "SELECT * FROM gym_sessions WHERE id = ?";

        List<GymSessionEntity> gymSessionEntity = jdbcTemplate.query(sql, rowMapper, id);
        return gymSessionEntity.stream()
                .map(gymSessionMapper::toDomain)
                .findFirst();
    }

    @Override
    public List<GymSession> findAll() {
        String sql = "SELECT * FROM gym_sessions";

        List<GymSessionEntity> gymSessionEntity = jdbcTemplate.query(sql, rowMapper);
        return gymSessionEntity.stream().map(gymSessionMapper::toDomain)
                .toList();
    }


    @Override
    public void deleteById(UUID id) {
        String sql = "DELETE FROM gym_sessions WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}