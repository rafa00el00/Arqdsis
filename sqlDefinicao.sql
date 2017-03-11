Create database sysPredial;
use sysPredial;


create table Empresa(
	id int primary key auto_increment
    ,razaosocial varchar(255)
    ,cnpj varchar(255)
    ,horarioAbertura Time
    ,horarioFechamento Time
	,temperaturaPadrao int
	,horaIniAr Time
	,horaFimAr Time
);

create table Conjunto(
	id int primary key auto_increment
	,nrConjunto varchar(255)
	,Andar varchar(255)
	,Alugel double
	,tamanho int
	,ocupado boolean
    ,empresaId int
    ,constraint FK_Conjunto_Empresa foreign key (empresaId) references Empresa(id)
);

create table Usuario(
	id int primary key auto_increment
    ,login varchar(255)
   ,senha varchar(255)
   ,perfil varchar(255)
   ,CPF varchar(255)
   ,nome varchar(255)
   ,horaAcesso datetime
   ,horaSaida datetime
    ,empresaId int
    ,constraint FK_Usuario_Empresa foreign key (empresaId) references Empresa(id)
);
