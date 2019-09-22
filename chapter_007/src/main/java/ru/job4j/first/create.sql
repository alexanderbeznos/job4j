create table users(
 id serial primary key,
 firstname varchar(2000),
 secondname varchar(2000)
);

create table roles(
 id serial primary key,
 role varchar(2000),
 users_id int references users(id)
);

create table rules(
 id serial primary key,
 rule varchar(2000)
);

create table roles_rules(
 id serial primary key,
 roles_id int references roles(id),
 rules_id int references rules(id)
);

create table state(
 id serial primary key,
 name varchar(2000)
);

create table category(
 id serial primary key,
 name varchar(2000)
 );

create table item (
 id serial primary key,
 name varchar(2000),
 user_id int references users(id),
 category_id int references category(id),
 state_id int references state(id)
);

create table attachs(
 id serial primary key,
 attach varchar(2000),
 item_id int references item(id)
);

create table comments(
 id serial primary key,
 comment varchar(2000),
 item_id int references item(id)
);