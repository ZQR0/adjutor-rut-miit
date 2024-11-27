--liquibase formatted sql

--changeset yaroslav:default-groups-2
INSERT INTO adjutor_schema.groups_table (group_name, group_description, join_link)
VALUES ('УВП-111', 'test', 't.me/test');

--changeset yaroslav:default-groups-updated
-- Группа УВП-112
INSERT INTO adjutor_schema.groups_table (group_name, group_description, join_link)
VALUES ('УВП-112', 'test', 't.me/test');

-- Группа УВВ-111
INSERT INTO adjutor_schema.groups_table (group_name, group_description, join_link)
VALUES ('УВВ-111', 'test', 't.me/test');

-- Группа УВВ-112
INSERT INTO adjutor_schema.groups_table (group_name, group_description, join_link)
VALUES ('УВВ-112', 'test', 't.me/test');

-- Группа УИБ-111
INSERT INTO adjutor_schema.groups_table (group_name, group_description, join_link)
VALUES ('УИБ-111', 'test', 't.me/test');

-- Группа УИБ-112
INSERT INTO adjutor_schema.groups_table (group_name, group_description, join_link)
VALUES ('УИБ-112', 'test', 't.me/test');

-- Группа УТА-111
INSERT INTO adjutor_schema.groups_table (group_name, group_description, join_link)
VALUES ('УТА-111', 'test', 't.me/test');

-- Группа УТА-112
INSERT INTO adjutor_schema.groups_table (group_name, group_description, join_link)
VALUES ('УТА-112', 'test', 't.me/test');

-- Группа УТН-111
INSERT INTO adjutor_schema.groups_table (group_name, group_description, join_link)
VALUES ('УТН-111', 'test', 't.me/test');

