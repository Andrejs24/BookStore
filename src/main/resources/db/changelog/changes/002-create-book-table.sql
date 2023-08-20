--liquibase formatted sql

--changeset ByMe:1

CREATE TABLE book
(
    id serial PRIMARY KEY ,
    Title VARCHAR(255) NOT NULL ,
    Author_id BIGINT NOT NULL ,
    Description VARCHAR(255) not null ,
    Price INTEGER not null ,
FOREIGN KEY (Author_id) REFERENCES author(id) On DELETE CASCADE ON UPDATE CASCADE
)