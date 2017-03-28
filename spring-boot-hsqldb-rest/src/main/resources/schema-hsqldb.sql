-- drop schema if exists restschema;
create schema restschema;
set schema restschema;

create table if not exists persons(
	id bigint identity primary key,
	firstName varchar(100) null,
	lastName varchar(100) null,
	age integer null
);
