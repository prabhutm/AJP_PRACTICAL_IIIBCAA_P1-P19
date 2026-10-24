drop database p11;
create database p11;
use p11;

 create table authors ( author_id int primary key auto_increment, first_name
varchar(100), last_name varchar(100) );
insert into authors (first_name, last_name) values ('John', 'Doe');
insert into authors (first_name, last_name) values ('Jane', 'Smith');
create table books ( book_id int primary key auto_increment, title varchar(255),
year int, isbn varchar(20), author_id int, foreign key (author_id) references authors(author_id) );insert into books (title, year, isbn, author_id) values ('Java Programming', 2020,
'1234567890', 1);
insert into books (title, year, isbn, author_id) values ('Database Design', 2018,
'0987654321', 2);
insert into books (title, year, isbn, author_id) values ('Advanced Java', 2021, '1122334455',
1);

