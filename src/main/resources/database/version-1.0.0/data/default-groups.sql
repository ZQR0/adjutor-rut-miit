--liquibase formatted sql

--changeset yaroslav:default-groups-1
INSERT INTO adjutor_schema.groups_table (group_name, group_description, join_link, creator_id, members_ids)
VALUES ('УВП-111', 'test', 't.me/test', 1, ARRAY[1]);

