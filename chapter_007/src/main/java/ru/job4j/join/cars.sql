create table body(
 id serial primary key,
 name varchar(200)
);

create table engine(
 id serial primary key,
 name varchar(200)
);
create table transmission(
 id serial primary key,
 name varchar(200)
);

create table cars(
 id serial primary key,
 name varchar(200),
 car_id int references body(id),
 engine_id int references engine(id),
 transmission_id int references transmission(id)
);

insert into body(name) values ('Для грузовых');
insert into body(name) values ('Для автобусов');
insert into body(name) values ('Для легковых');
insert into body(name) values ('Для спецтехники');

insert into engine(name) values ('Бензиновый');
insert into engine(name) values ('Электрический');
insert into engine(name) values ('Газовый');

insert into transmission(name) values ('Механическая');
insert into transmission(name) values ('Автоматическая');

insert into cars(name, car_id, engine_id, transmission_id) values
('Toyota', 3, 1, 1);
insert into cars(name, car_id, engine_id, transmission_id) values
('Сat', 4, 2, 2);
insert into cars(name, car_id, engine_id, transmission_id) values
('Volkswagen', 2, 1, 2);

select i.name, c.name, q.name, w.name from cars as i
  inner join body as c on i.car_id = c.id
  inner join engine as q on i.engine_id= q.id
  inner join transmission as w on i.transmission_id = w.id

select g.name, t.name from cars as g right outer
join body as t on g.car_id = t.id where g.id is null;

select g.name, t.name from cars as g right outer
join engine as t on g.engine_id = t.id where g.id is null;

select g.name, t.name from cars as g right outer
join transmission as t on g.transmission_id = t.id where g.id is null;