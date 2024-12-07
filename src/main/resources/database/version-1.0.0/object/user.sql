--liquibase formatted sql

--changeset yaroslav:user-1
CREATE TABLE IF NOT EXISTS adjutor_schema.users_table (
    user_id              INTEGER     NOT NULL    PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    first_name           VARCHAR     NOT NULL,
    last_name            VARCHAR     NOT NULL,
    patronymic           VARCHAR     NOT NULL,
    snils                VARCHAR     NOT NULL    UNIQUE,
    role                 VARCHAR     NOT NULL,
    is_deleted           BOOLEAN     NOT NULL    DEFAULT FALSE,
    registration_date    DATE        NOT NULL    DEFAULT CURRENT_DATE,
    created_groups_names TEXT[]
);

CREATE UNIQUE INDEX IF NOT EXISTS idx_users_n1 ON adjutor_schema.users_table (user_id);
