CREATE TABLE gym_sessions (
                              id UUID PRIMARY KEY,
                              gym_name VARCHAR(255) NOT NULL,
                              day_of_week VARCHAR(20) NOT NULL,
                              completed BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE INDEX idx_gym_sessions_day_of_week ON gym_sessions(day_of_week);
CREATE INDEX idx_gym_sessions_gym_name ON gym_sessions(gym_name);