create database quarkus-social;

create table users
(
    id bigserial not null primary key,
    name varchar(100) not null,
    age  integer      not null
);

select *
from users;

CREATE TABLE posts
(
    id bigserial not null primary key,
    post_text VARCHAR(150) NOT NULL,
    dateTime TIMESTAMP,
    user_id BIGINT NOT NULL REFERENCES users(id)
);

CREATE TABLE followers
(
    id bigserial not null primary key,
    user_id BIGINT NOT NULL REFERENCES users(id),
    follower_id BIGINT NOT NULL REFERENCES users(id)
);