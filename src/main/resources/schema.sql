drop table if exists collaborators;

create table collaborators (
    id int not null identity,
    name varchar(255) not null,
    cpf varchar(11) not null,
    primary key(id)
);

drop table if exists items;

create table items (
    id int not null identity,
    name varchar(255) not null,
    primary key(id)
);