create table t_pharmacy
(
    id   integer auto_increment,
    code varchar(50),
    name varchar(50),
    primary key (id)
);

create table t_pill
(
    id             integer auto_increment,
    name         varchar(50),
    price        integer,
    stockNumber  integer,
    description  varchar(50),
    name_pharmacy varchar(50),
    primary key (id),
    foreign key (name_pharmacy) references t_pharmacy (name)
);