--liquibase formatted sql

--changeset yaroslav:default-users-1
INSERT INTO adjutor_schema.users_table (first_name, last_name, phone_number, patronymic, role, snils)
VALUES ('Ivan', 'Ivanov', '8999999999', 'Ivanovich', 'admin', '123-456-789 12');
