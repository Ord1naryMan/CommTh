drop table if exists users;
drop table if exists message;

create table users (
                      id bigserial primary key ,
                      username char(128) not null unique ,
                      mail char(128) not null unique,
                      chat_quantity int not null
);

create table message (
    message_id uuid not null unique primary key ,
    users_id_from bigint not null,
    users_id_to bigint not null,
    time timestamp not null
);