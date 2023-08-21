--liquibase formatted sql

--changeset ByMe:1

CREATE TABLE author
(
    id serial PRIMARY KEY,
First_Name VARCHAR(255) NOT NULL ,
Last_Name VARCHAR(255) NOT NULL,
Language VARCHAR(255) NOT NULL ,
Book_count INTEGER not null
)