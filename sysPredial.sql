create database sysPredial;

use sysPredial;

create table Usuario(
	id int auto_increment
	,login varchar(100)
	,nome varchar(150)
	,cpf varchar(11)
	,empresa_id int
	,horaAcesso time
	,horaSaida time
	,Constraint pk_usuario primary key (id)
);


create table empresa(
	id int auto_increment
	,cnpj varchar(14)
	,razaosocial varchar(150)
	,TemperaturaAr int
	,horaAbertura time
	,horaFechamento time
	,horaIniAr time
	,horaFimAr time
	,Constraint pk_empresa primary key (id)
);
/*GRANT ALL PRIVILEGES ON sysPredial.* To 'alunos'@'localhost' IDENTIFIED BY 'alunos';*/