1.select * from product as i
  inner join type as c on i.type_id = c.id
  where c.name = 'СЫР';
2.select * from product as u
  where u.name like '%Мороженое%';
3.select * from product as u
  where extract (month from u.expired_date) = extract (month from now()) + 1;
4.select * from product as u
  where u.price = (select MAX(price) from product);
5.select * from product as i
  inner join type as c on i.type_id = c.id
  where c.name = 'СЫР';
6.select * from product as i
  inner join type as c on i.type_id = c.id
  where c.name = 'СЫР' or c.name = 'МОЛОКО';
7.select type_id, count(type_id)
  from product
  group by type_id
  having count(type_id) < 10
8.select product.name, type.name from product
  inner join type on product.type_id = type.id
  или
   select i.name, c.name from product as i
   inner join type as c on i.type_id = c.id



   create table type(
    id serial primary key,
    name character varying(2000)
    );

   create table product(
   id serial primary key,
   name character varying(2000),
   type_id int references type(id),
   expired_date timestamp,
   price int
   );

   insert into type(name) values ('СЫР');
   insert into type(name) values ('МОЛОКО');
   insert into type(name) values ('Вода');
   insert into type(name) values ('Фрукты');
   insert into type(name) values ('Овощи');

   insert into product(name, type_id, expired_date, price) values ('Российский', '1',
   '2019-09-20 10:15:58', '620');
   insert into product(name, type_id, expired_date, price) values ('Голландский ', '1',
   '2019-09-10 15:20:15', '350');
   insert into product(name, type_id, expired_date, price) values ('Вкусный', '1',
   '2019-09-03 18:11:54', '380');
   insert into product(name, type_id, expired_date, price) values ('Молочник', '2',
   '2019-09-22 17:12:08', '95');
   insert into product(name, type_id, expired_date, price) values ('Мороженое', '2',
   '