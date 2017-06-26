
create schema genet_woldeyes_potluckDB;
create user 'springuser'@'localhost' identified by 'ThePassword';
grant all on genet_woldeyes_potluckDB.* to 'springuser'@'localhost';

select * from chef;