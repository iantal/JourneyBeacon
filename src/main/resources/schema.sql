-- user
create table IF NOT EXISTS Users (
    id serial primary key,
    email varchar(255) not null,
    user_id varchar(100) not null,
    id_token varchar(100) not null,
    display_name varchar(100) not null
);