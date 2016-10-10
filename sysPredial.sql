create database sysPredial;

use sysPredial;

create table conjunto(
	id int auto_increment
	,nrConjunto varchar(10)
	,andar varchar(20)
	,alugel double
	,tamanho int
	,ocupado bit null
	,CONSTRAINT pk_conjunto primary key (id)
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
	,Conjunto_id int
	,Constraint pk_empresa primary key (id)
	,CONSTRAINT fk_empresa_Consjunto FOREIGN key (Conjunto_id) references Conjunto(id) on delete cascade
);


create table Usuario(
	id int auto_increment
	,login varchar(100)
	,nome varchar(150)
	,cpf varchar(11)
	,empresa_id int
	,horaAcesso time
	,horaSaida time
	,Constraint pk_usuario primary key (id)
	,Constraint fk_empresa_usuario foreign key (empresa_id) references empresa(id) on delete cascade
);


Create trigger tr_ocuparConjunto
AFTER insert on empresa FOR EACH ROW
begin
	update Conjunto set ocupado = 1 where id = New.conjunto_id;
end;

Create trigger tr_ocuparConjunto_up
BEFORE update on empresa FOR EACH ROW
begin
	update conjunto set ocupado = 0 where id = old.conjunto_id;
	update Conjunto set ocupado = 1 where id = New.conjunto_id;
end;

create trigger tr_desocuparConjunto
before delete on empresa FOR EACH ROW
begin
	update Conjunto set ocupado = 0 where id = old.conjunto_id;
end;



/*GRANT ALL PRIVILEGES ON sysPredial.* To 'alunos'@'localhost' IDENTIFIED BY 'alunos';*/