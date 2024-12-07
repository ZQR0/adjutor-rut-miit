--liquibase formatted sql

--changeset yaroslav:group-4
CREATE TABLE IF NOT EXISTS adjutor_schema.groups_table (
    group_id            INTEGER         NOT NULL        GENERATED ALWAYS AS IDENTITY,
    group_name          VARCHAR(100)    NOT NULL        UNIQUE,
    group_description   VARCHAR(100)    NOT NULL,
    join_link           VARCHAR(500)    NOT NULL,
    is_deleted          BOOLEAN         NOT NULL        DEFAULT FALSE,
    is_added_to_list    BOOLEAN         NOT NULL        DEFAULT FALSE,
    creation_date_time  TIMESTAMP       NOT NULL        DEFAULT CURRENT_TIMESTAMP,
    updating_date_time  TIMESTAMP       NOT NULL        DEFAULT CURRENT_TIMESTAMP
);

CREATE UNIQUE INDEX IF NOT EXISTS idx_groups_n1 ON adjutor_schema.groups_table (group_id);

CREATE OR REPLACE FUNCTION update_modified_column()
RETURNS TRIGGER AS
$$
    BEGIN
        NEW.updating_time = now();
        RETURN NEW;
    END
$$ language 'plpgsql';


-- updating trigger
--CREATE TRIGGER updating_date_trigger_groups_table BEFORE UPDATE ON adjutor_schema.groups_table FOR EACH ROW EXECUTE PROCEDURE update_modified_column();
