--liquibase formatted sql

--changeset yaroslav:user-1
CREATE TABLE IF NOT EXISTS adjutor_schema.users_table (
    user_id             INTEGER     NOT NULL    GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    first_name          VARCHAR     NOT NULL,
    last_name           VARCHAR     NOT NULL,
    phone_number        VARCHAR     NOT NULL    UNIQUE,
    patronymic          VARCHAR     NOT NULL,
    role                VARCHAR     NOT NULL,
    snils               VARCHAR     NOT NULL    UNIQUE,
    is_deleted          BOOLEAN     NOT NULL    DEFAULT TRUE,
    registration_date   DATE        NOT NULL    DEFAULT CURRENT_DATE
);
