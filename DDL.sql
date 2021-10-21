create schema thule;

use thule;

create user 'user'@'localhost' identified by 'admin';

grant select, insert, delete, update on thule.* to user@'localhost';

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

create table grp_grupo (
	grp_id bigint unsigned not null auto_increment,
	grp_nome varchar(50) not null,
	primary key (grp_id)
);

create table mkt_canal (
	mkt_id bigint unsigned not null auto_increment,
	mkt_nome varchar(50) not null,
	primary key (mkt_id)
);

create table uf_estado (
	uf_id bigint unsigned not null auto_increment,
	uf_nome varchar(50) not null,
	primary key (uf_id)
);

create table cnpj_empresa (
	cnpj_id bigint unsigned not null auto_increment,
	cnpj_nome varchar(50) not null,
	primary key (cnpj_id)
);

create table vnd_venda (
	vnd_id bigint unsigned not null auto_increment,
	usr_id bigint unsigned not null,
	cnpj_id bigint unsigned not null,
	uf_id bigint unsigned not null,
	mkt_id bigint unsigned not null,
	grp_id bigint unsigned not null,
	vnd_valor float not null,
	vnd_data_hora datetime not null,
	primary key (vnd_id),
	foreign key vnd_usr_fk (usr_id)
	references usr_usuario (usr_id)
	on delete restrict on update cascade,
	foreign key vnd_cnpj_fk (cnpj_id)
	references cnpj_empresa (cnpj_id)
	on delete restrict on update cascade,
	foreign key vnd_uf_fk (uf_id)
	references uf_estado (uf_id)
	on delete restrict on update cascade,
	foreign key vnd_mkt_fk (mkt_id)
	references mkt_canal (mkt_id)
	on delete restrict on update cascade,
	foreign key vnd_grp_fk (grp_id)
	references grp_grupo (grp_id)
	on delete restrict on update cascade
);

insert into usr_usuario (usr_nome, usr_email, usr_senha) values ('Renato', 'renato@thulestore-colinas.com.br', 'admin');
insert into aut_autorizacao (aut_nome) values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao (1, 1);