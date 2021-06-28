create table if not exists collaborators (
    id int not null identity,
    full_name varchar(255) not null,
    cpf varchar(11) not null,
    primary key(id)
);

create table if not exists items (
    id int not null identity,
    name varchar(255) not null,
    primary key(id)
);

create table if not exists collaborator_items (
    id int not null identity,
    collaborator_id int not null,
    item_id int not null,
    primary key(id),
    foreign key (collaborator_id) references (collaborator_id),
    foreign key (item_id) references (item_id)
);