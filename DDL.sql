
create database spring;

use spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

create table usuario (
	cod_usuario bigint unsigned not null auto_increment,
	nome varchar(20) not null,
	senha varchar(50) not null,
	primary key (cod_usuario),
	unique key uni_nome (nome)
);

create table autorizacao(
	cod_aut bigint unsigned not null auto_increment,
	aut_nome varchar(20) not null,
	primary key (cod_aut),
	unique key uni_aut_nome (aut_nome)
);

create table usuario_autorizacao(
	cod_usuario bigint unsigned not null,
	cod_aut bigint unsigned not null,
	primary key (cod_usuario, cod_aut),
	foreign key usuario_fk (cod_usuario) references usuario (cod_usuario),
	foreign key aut_fk (cod_aut) references autorizacao (cod_aut)
);

insert into usuario (nome, senha) values ('Primeiro Usuario', '123');
insert into autorizacao (aut_nome) values ('Admin');
insert into usuario_autorizacao values (1,1);