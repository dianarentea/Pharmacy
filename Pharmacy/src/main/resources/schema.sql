create table t_pharmacy
(
    id  integer  auto_increment,
    name varchar(50),
    primary key (id)
);

create table t_pill
(
    id  integer auto_increment,
    name varchar(50),
    price double precision,
    stockNumber integer,
    description varchar(50),
    id_pharmacy integer,
    primary key (id),
    foreign key (id_pharmacy) references t_pharmacy (id)
);
