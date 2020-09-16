create schema anotacao; 

use anotacao;
 
create user 'user'@'localhost' identified by 'pass123'; 

grant select, insert, delete, update on anotacao.* to user@'localhost';
 
create table usr usuario ( 
  usr_id bigint unsigned not null auto increment, 
  usr_nome varchar(20) not null, 
  usr senha varchar(50) not null, 
  primary key (usr_id), 
  unique key uni_usuarfo_nome (usr_nome) 
);