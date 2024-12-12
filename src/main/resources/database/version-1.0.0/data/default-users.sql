--liquibase formatted sql

--changeset yaroslav:default-users-2
INSERT INTO adjutor_schema.users_table (first_name, last_name, patronymic, role, snils, created_groups_names)
VALUES ('Olesya', 'Adminov', 'Adminovich', 'admin', '123-456-789 12', ARRAY['']);
