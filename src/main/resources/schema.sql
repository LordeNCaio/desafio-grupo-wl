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

drop table if exists collaborator_items;

create table collaborator_items (
    id int not null identity,
    collaborator_id int not null,
    items_id int not null,
    primary key(id),
    foreign key (collaborator_id) references (collaborator_id),
    foreign key (items_id) references (items_id)
);