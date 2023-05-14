-- user
create table IF NOT EXISTS Users (
    id serial primary key,
    email varchar(255) not null,
    user_id varchar(100) not null,
    id_token varchar(100) not null,
    display_name varchar(100) not null
);

-- payment
create table IF NOT EXISTS Payments (
    id serial primary key,
    user_id varchar(100) not null,
    timestmp varchar(255) not null,
    amount varchar(100) not null,
    route varchar(100) not null
);