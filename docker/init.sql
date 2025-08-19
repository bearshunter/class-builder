CREATE DATABASE testdb;
ALTER DATABASE testdb SET TIME ZONE 'Europe/Kyiv';

\c testdb;

CREATE SCHEMA IF NOT EXISTS cb;

CREATE TABLE IF NOT EXISTS cb.sample (
                                         id SERIAL PRIMARY KEY,
                                         name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

GRANT ALL PRIVILEGES ON DATABASE testdb TO "cb-admin";
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA cb TO "cb-admin";
