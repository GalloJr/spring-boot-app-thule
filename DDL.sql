create schema thule;

create user 'user'@'localhost' identified by 'admin';

grant select, insert, delete, update on thule.* to user@'localhost';

use thule;

create table usr_usuario (
	usr_id bigint unsigned not null auto_increment,
	usr_nome varchar(20) not null,
	usr_email varchar(100) not null,
	usr_senha varchar(100) not null,
	primary key (usr_id),
	unique key uni_usuario_nome (usr_nome),
	unique key uni_usuario_email (usr_email)
);
create table aut_autorizacao (
	aut_id bigint unsigned not null auto_increment,
	aut_nome varchar(20) not null,
	primary key (aut_id),
	unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
	usr_id bigint unsigned not null,
	aut_id bigint unsigned not null,
	primary key (usr_id, aut_id),
	foreign key uau_usr_fk (usr_id)
	references usr_usuario (usr_id)
	on delete restrict on update cascade,
	foreign key uau_aut_fk (aut_id)
	references aut_autorizacao (aut_id)
	on delete restrict on update cascade
);

create table cli_cliente (
	cli_id bigint unsigned not null auto_increment,
	cli_nome varchar(20) not null,
	cli_email varchar(100) not null,
	cli_uf varchar (2) not null,
	primary key (usr_id),
	unique key uni_cliente_nome (cli_nome),
	unique key uni_cliente_email (cli_email)
);

create table prd_produto (
	prd_id bigint unsigned not null auto_increment,
	prd_nome varchar(50) not null,
	prd_cat varchar(50) not null,
	primary key (prd_id)
);

create table vnd_venda (
	vnd_id bigint unsigned not null auto_increment,
	cli_id bigint unsigned not null,
	prd_id bigint unsigned not null,
	vnd_valor float not null,
	vnd_data datetime not null,
	primary key (vnd_id),
	foreign key vnd_cli_fk (cli_id)
	references cli_cliente (cli_id)
	on delete restrict on update cascade,
	foreign key vnd_prd_fk (prd_id)
	references prd_produto (prd_id)
	on delete restrict on update cascade
);

insert into usr_usuario (usr_nome, usr_email, usr_senha)
  values ('admin', 'admin@email.com', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');

insert into aut_autorizacao (aut_nome)
  value ('ROLE_ADMIN');

insert into uau_usuario_autorizacao (usr_id, aut_id)
  select usr_id, aut_id
    from usr_usuario, aut_autorizacao
    where usr_nome = 'admin'
    and aut_nome = 'ROLE_ADMIN';

insert into prd_produto (prd_nome, prd_cat)
	values
		('mochila', 'pbl'),
		('carrinho de bebe', 'awk'),
		('transbike', 's&c'),
		('mala', 'pbl'),
		('cadeirinha de bike', 'awk'),
		('rack', 's&c');

insert into cli_cliente (cli_nome, cli_email, cli_uf)
	values
		('renato','renato@email.com','sp'),
		('jose','jose@email.com','sp'),
		('joao','joao@email.com','rj'),
		('juliane','juliane@email.com','rj'),
		('renan','renan@email.com','mg'),
		('josi','josi@email.com','mg');

insert into vnd_venda (cli_id, prd_id, vnd_valor, vnd_data)
	values
		(1,1,899.90,19/05/2022),
		(2,2,4899.90,15/05/2022),
		(3,3,5899.90,16/05/2022),
		(4,4,2899.90,18/05/2022),
		(5,5,1899.90,19/05/2022);
		
		
		