create database employee_login;
use employee_login;

create table login
(email varchar(25),
pass varchar(16));

insert into login values('test@gmail.com','test@123');
insert into login values('Raju@gmail.com','raju@12345');

select * from login;
