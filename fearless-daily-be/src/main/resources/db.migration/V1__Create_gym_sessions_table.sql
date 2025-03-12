CREATE TABLE gym_sessions (
                              id UUID PRIMARY KEY,
                              gym_name VARCHAR(255) NOT NULL,
                              day_of_week VARCHAR(20) NOT NULL,
                              completed BOOLEAN NOT NULL DEFAULT FALSE
);
