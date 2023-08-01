create table t_pharmacy
(
    id   integer auto_increment,
    code varchar(50),
    name varchar(50),
    primary key (id)
);

create table t_pill
(
    id           integer auto_increment,
    name         varchar(50),
    price        integer,
    stock_number  integer,
    description  varchar(50),
    image_name varchar(50),
    id_pharmacy varchar(50),
    primary key (id),
    foreign key (id_pharmacy) references t_pharmacy (id)
);