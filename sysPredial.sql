create database sysPredial;

use sysPredial;

create table Usuario(
	id int auto_increment
	,login varchar(100)
	,nome varchar(150)
	,cpf varchar(11)
	,empresa_id int
	,horaAcesso datetime
	,horaSaida datetime
	,Constraint pk_usuario primary key (id)
);


create table empresa(
	id int auto_increment
	,cnpj varchar(14)
	,razaosocial varchar(150)
	,TemperaturaAr int
	,horaAbertura datetime
	,horaFechamento datetime
	,horaIniAr datetime
	,horaFimAr datetime
	,Constraint pk_empresa primary key (id)
);
/*GRANT ALL PRIVILEGES ON sysPredial.* To 'alunos'@'localhost' IDENTIFIED BY 'alunos';*/