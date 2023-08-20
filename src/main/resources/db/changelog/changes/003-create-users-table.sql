--liquibase formatted sql

--changeset ByMe:1
CREATE TABLE users
(
    id serial PRIMARY KEY,
    UserName VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Role VARCHAR(255) NOT NULL
);




