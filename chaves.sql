/************ Update: Tables ***************/

/******************** Add Table: "schemaA"."Aluno" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Aluno"
(
	"Id" INTEGER NOT NULL,
	"Matricula" VARCHAR(20) NOT NULL,
	"Pessoa_Id" INTEGER NOT NULL,
	"Curso_Id" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Aluno" ADD CONSTRAINT "pkAluno"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Curso" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Curso"
(
	"Id" INTEGER NOT NULL,
	"Nome" VARCHAR(100) NOT NULL,
	"Nivel" VARCHAR(50) NOT NULL,
	"Departamento_Id" INTEGER NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Curso" ADD CONSTRAINT "pkCurso"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Departamento" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Departamento"
(
	"Id" INTEGER NOT NULL,
	"Nome" VARCHAR(100) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Departamento" ADD CONSTRAINT "pkDepartamento"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Equipamento" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Equipamento"
(
	"Id" INTEGER NOT NULL,
	"Descricao" VARCHAR(512) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Equipamento" ADD CONSTRAINT "pkEquipamento"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Locacao" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Locacao"
(
	"Id" INTEGER NOT NULL,
	"Aluno_Id" INTEGER NOT NULL,
	"Sala_Id" INTEGER NOT NULL,
	"Hora_Inicio" TIMESTAMP NULL,
	"Hora_Final" TIMESTAMP NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Locacao" ADD CONSTRAINT "pkLocacao"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Pavilhao" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Pavilhao"
(
	"Id" INTEGER NOT NULL,
	"Nome" VARCHAR(512) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Pavilhao" ADD CONSTRAINT "pkPavilhao"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Permissao" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Permissao"
(
	"Id" INTEGER NOT NULL,
	"Tipo_Usuario_Id" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Permissao" ADD CONSTRAINT "pkPermissao"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Pessoa" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Pessoa"
(
	"Id" INTEGER NOT NULL,
	"Name" VARCHAR(100) NOT NULL,
	"Email" VARCHAR(100) NOT NULL,
	"Telefone" VARCHAR(20) NULL,
	"Foto" VARCHAR(250) NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Pessoa" ADD CONSTRAINT "pkPessoa"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Pessoa_Usuario" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Pessoa_Usuario"
(
	"Pessoa_Id" INTEGER NOT NULL,
	"Tipo_Usuario_Id" INTEGER NOT NULL
);


/******************** Add Table: "schemaA"."Professor" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Professor"
(
	"Id" INTEGER NOT NULL,
	"Num_siap" VARCHAR(20) NOT NULL,
	"Departamento_Id" INTEGER NOT NULL,
	"Pessoa_Id" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Professor" ADD CONSTRAINT "pkProfessor"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Reserva" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Reserva"
(
	"Id" INTEGER NOT NULL,
	"Professor_Id" INTEGER NOT NULL,
	"Sala_Id" INTEGER NOT NULL,
	"Hora_Inicio" TIMESTAMP NULL,
	"Hora_Final" TIMESTAMP NULL,
	"Tecnico_Id" INTEGER NULL,
	"Status_Reserva_Id" INTEGER NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Reserva" ADD CONSTRAINT "pkReserva"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Sala" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Sala"
(
	"Id" INTEGER NOT NULL,
	"Numero" VARCHAR(20) NOT NULL,
	"Capacidade" INTEGER NULL,
	"Pavilhao_Id" INTEGER NULL,
	"Tipo_Sala_Id" INTEGER NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Sala" ADD CONSTRAINT "pkSala"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Sala_Equipamento" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Sala_Equipamento"
(
	"Id" INTEGER NOT NULL,
	"Quantidade" INTEGER NOT NULL,
	"Equipamento_Id" INTEGER NULL,
	"Sala_Id" INTEGER NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Sala_Equipamento" ADD CONSTRAINT "pkSala_Equipamento"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Status_Reserva" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Status_Reserva"
(
	"Id" INTEGER NOT NULL,
	"Descricao" VARCHAR(512) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Status_Reserva" ADD CONSTRAINT "pkStatus_Reserva"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Tecnico" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Tecnico"
(
	"Id" INTEGER NOT NULL,
	"Departamento_Id" INTEGER NOT NULL,
	"Pessoa_Id" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Tecnico" ADD CONSTRAINT "pkTecnico"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Tipo_Sala" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Tipo_Sala"
(
	"Id" INTEGER NOT NULL,
	"Descricao" VARCHAR(256) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Tipo_Sala" ADD CONSTRAINT "pkTipo_Sala"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Tipo_Usuario" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Tipo_Usuario"
(
	"Id" INTEGER NOT NULL,
	"Descricao" VARCHAR(50) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Tipo_Usuario" ADD CONSTRAINT "pkTipo_Usuario"
	PRIMARY KEY ("Id");


/******************** Add Table: "schemaA"."Usuario" ************************/

/* Build Table Structure */
CREATE TABLE "schemaA"."Usuario"
(
	"Id" INTEGER NOT NULL,
	"Login" VARCHAR(50) NOT NULL,
	"Senha" VARCHAR(100) NOT NULL,
	"Pessoa_Id" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "schemaA"."Usuario" ADD CONSTRAINT "pkUsuario"
	PRIMARY KEY ("Id");





/************ Add Foreign Keys ***************/

/* Add Foreign Key: fk_Aluno_Curso */
ALTER TABLE "schemaA"."Aluno" ADD CONSTRAINT "fk_Aluno_Curso"
	FOREIGN KEY ("Curso_Id") REFERENCES "schemaA"."Curso" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Aluno_Pessoa */
ALTER TABLE "schemaA"."Aluno" ADD CONSTRAINT "fk_Aluno_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "schemaA"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Curso_Departamento */
ALTER TABLE "schemaA"."Curso" ADD CONSTRAINT "fk_Curso_Departamento"
	FOREIGN KEY ("Departamento_Id") REFERENCES "schemaA"."Departamento" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Locacao_Aluno */
ALTER TABLE "schemaA"."Locacao" ADD CONSTRAINT "fk_Locacao_Aluno"
	FOREIGN KEY ("Aluno_Id") REFERENCES "schemaA"."Aluno" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Locacao_Sala */
ALTER TABLE "schemaA"."Locacao" ADD CONSTRAINT "fk_Locacao_Sala"
	FOREIGN KEY ("Sala_Id") REFERENCES "schemaA"."Sala" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Permissao_Tipo_Usuario */
ALTER TABLE "schemaA"."Permissao" ADD CONSTRAINT "fk_Permissao_Tipo_Usuario"
	FOREIGN KEY ("Tipo_Usuario_Id") REFERENCES "schemaA"."Tipo_Usuario" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Pessoa_Usuario_Pessoa */
ALTER TABLE "schemaA"."Pessoa_Usuario" ADD CONSTRAINT "fk_Pessoa_Usuario_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "schemaA"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Pessoa_Usuario_Tipo_Usuario */
ALTER TABLE "schemaA"."Pessoa_Usuario" ADD CONSTRAINT "fk_Pessoa_Usuario_Tipo_Usuario"
	FOREIGN KEY ("Tipo_Usuario_Id") REFERENCES "schemaA"."Tipo_Usuario" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Professor_Departamento */
ALTER TABLE "schemaA"."Professor" ADD CONSTRAINT "fk_Professor_Departamento"
	FOREIGN KEY ("Departamento_Id") REFERENCES "schemaA"."Departamento" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Professor_Pessoa */
ALTER TABLE "schemaA"."Professor" ADD CONSTRAINT "fk_Professor_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "schemaA"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Reserva_Professor */
ALTER TABLE "schemaA"."Reserva" ADD CONSTRAINT "fk_Reserva_Professor"
	FOREIGN KEY ("Professor_Id") REFERENCES "schemaA"."Professor" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Reserva_Sala */
ALTER TABLE "schemaA"."Reserva" ADD CONSTRAINT "fk_Reserva_Sala"
	FOREIGN KEY ("Sala_Id") REFERENCES "schemaA"."Sala" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Reserva_Status_Reserva */
ALTER TABLE "schemaA"."Reserva" ADD CONSTRAINT "fk_Reserva_Status_Reserva"
	FOREIGN KEY ("Status_Reserva_Id") REFERENCES "schemaA"."Status_Reserva" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Reserva_Tecnico */
ALTER TABLE "schemaA"."Reserva" ADD CONSTRAINT "fk_Reserva_Tecnico"
	FOREIGN KEY ("Tecnico_Id") REFERENCES "schemaA"."Tecnico" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Sala_Pavilhao */
ALTER TABLE "schemaA"."Sala" ADD CONSTRAINT "fk_Sala_Pavilhao"
	FOREIGN KEY ("Pavilhao_Id") REFERENCES "schemaA"."Pavilhao" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Sala_Tipo_Sala */
ALTER TABLE "schemaA"."Sala" ADD CONSTRAINT "fk_Sala_Tipo_Sala"
	FOREIGN KEY ("Tipo_Sala_Id") REFERENCES "schemaA"."Tipo_Sala" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Sala_Equipamento_Equipamento */
ALTER TABLE "schemaA"."Sala_Equipamento" ADD CONSTRAINT "fk_Sala_Equipamento_Equipamento"
	FOREIGN KEY ("Equipamento_Id") REFERENCES "schemaA"."Equipamento" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Sala_Equipamento_Sala */
ALTER TABLE "schemaA"."Sala_Equipamento" ADD CONSTRAINT "fk_Sala_Equipamento_Sala"
	FOREIGN KEY ("Sala_Id") REFERENCES "schemaA"."Sala" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Tecnico_Departamento */
ALTER TABLE "schemaA"."Tecnico" ADD CONSTRAINT "fk_Tecnico_Departamento"
	FOREIGN KEY ("Departamento_Id") REFERENCES "schemaA"."Departamento" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Tecnico_Pessoa */
ALTER TABLE "schemaA"."Tecnico" ADD CONSTRAINT "fk_Tecnico_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "schemaA"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Usuario_Pessoa */
ALTER TABLE "schemaA"."Usuario" ADD CONSTRAINT "fk_Usuario_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "schemaA"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;