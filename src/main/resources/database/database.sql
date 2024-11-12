--liquibase formatted sql

--changeset yaroslav:database-1
CREATE DATABASE IF NOT EXISTS adjutor_db OWNER postgres;
