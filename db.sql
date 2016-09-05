/************ Update: Schemas ***************/

ALTER SCHEMA "schemaA" RENAME TO "Chaves";





/************ Update: Tables ***************/

/******************** Add Table: "Chaves"."Acao" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Acao"
(
	"Id" INTEGER NOT NULL,
	"Descricao" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Acao" ADD CONSTRAINT "pkAcao"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Aluno" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Aluno"
(
	"Id" INTEGER NOT NULL,
	"Matricula" VARCHAR(20) NOT NULL,
	"Pessoa_Id" INTEGER NOT NULL,
	"Curso_Id" INTEGER NULL,
	"Aluno_visitante" BOOL NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Aluno" ADD CONSTRAINT "pkAluno"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Curso" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Curso"
(
	"Id" INTEGER NOT NULL,
	"Nome" VARCHAR(100) NOT NULL,
	"Nivel" VARCHAR(50) NOT NULL,
	"Departamento_Id" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Curso" ADD CONSTRAINT "pkCurso"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Departamento" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Departamento"
(
	"Id" INTEGER NOT NULL,
	"Nome" VARCHAR(100) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Departamento" ADD CONSTRAINT "pkDepartamento"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Equipamento" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Equipamento"
(
	"Id" INTEGER NOT NULL,
	"Descricao" VARCHAR(512) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Equipamento" ADD CONSTRAINT "pkEquipamento"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Locacao" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Locacao"
(
	"Id" INTEGER NOT NULL,
	"Sala_Id" INTEGER NOT NULL,
	"Hora_Inicio" TIMESTAMP NULL,
	"Hora_Final" TIMESTAMP NULL,
	"Pessoa_Id" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Locacao" ADD CONSTRAINT "pkLocacao"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Pavilhao" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Pavilhao"
(
	"Id" INTEGER NOT NULL,
	"Nome" VARCHAR(512) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Pavilhao" ADD CONSTRAINT "pkPavilhao"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Permissao" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Permissao"
(
	"Id" INTEGER NOT NULL,
	"Tipo_Usuario_Id" INTEGER NOT NULL,
	"Acao_Id" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Permissao" ADD CONSTRAINT "pkPermissao"
	PRIMARY KEY ("Id", "Tipo_Usuario_Id", "Acao_Id");


/******************** Add Table: "Chaves"."Pessoa" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Pessoa"
(
	"Id" INTEGER NOT NULL,
	"Name" VARCHAR(100) NOT NULL,
	"Email" VARCHAR(100) NOT NULL,
	"Telefone" VARCHAR(20) NULL,
	"Foto" VARCHAR(250) NULL,
	"Login" VARCHAR(50) NOT NULL,
	"Senha" VARCHAR(100) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Pessoa" ADD CONSTRAINT "pkPessoa"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Pessoa_Usuario" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Pessoa_Usuario"
(
	"Pessoa_Id" INTEGER NOT NULL,
	"Tipo_Usuario_Id" INTEGER NOT NULL
);


/******************** Add Table: "Chaves"."Professor" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Professor"
(
	"Id" INTEGER NOT NULL,
	"Num_siap" VARCHAR(20) NOT NULL,
	"Departamento_Id" INTEGER NULL,
	"Pessoa_Id" INTEGER NOT NULL,
	"Professor_visitante" BOOL NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Professor" ADD CONSTRAINT "pkProfessor"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Reserva" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Reserva"
(
	"Id" INTEGER NOT NULL,
	"Professor_Id" INTEGER NOT NULL,
	"Sala_Id" INTEGER NOT NULL,
	"Hora_Inicio" TIMESTAMP NULL,
	"Hora_Final" TIMESTAMP NULL,
	"Tecnico_Id" INTEGER NULL,
	"Status_Reserva" INTEGER NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Reserva" ADD CONSTRAINT "pkReserva"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Sala" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Sala"
(
	"Id" INTEGER NOT NULL,
	"Numero" VARCHAR(20) NOT NULL,
	"Capacidade" INTEGER NOT NULL,
	"Pavilhao_Id" INTEGER NOT NULL,
	"Tipo_Sala" INTEGER NOT NULL,
	"Descricao_equipamentos" VARCHAR(255) NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Sala" ADD CONSTRAINT "pkSala"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Sala_Equipamento" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Sala_Equipamento"
(
	"Id" INTEGER NOT NULL,
	"Quantidade" INTEGER NOT NULL,
	"Equipamento_Id" INTEGER NULL,
	"Sala_Id" INTEGER NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Sala_Equipamento" ADD CONSTRAINT "pkSala_Equipamento"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Status_Reserva" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Status_Reserva"
(
	"Id" INTEGER NOT NULL,
	"Descricao" VARCHAR(512) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Status_Reserva" ADD CONSTRAINT "pkStatus_Reserva"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Tecnico" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Tecnico"
(
	"Id" INTEGER NOT NULL,
	"Departamento_Id" INTEGER NULL,
	"Pessoa_Id" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Tecnico" ADD CONSTRAINT "pkTecnico"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Tipo_Sala" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Tipo_Sala"
(
	"Id" INTEGER NOT NULL,
	"Descricao" VARCHAR(256) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Tipo_Sala" ADD CONSTRAINT "pkTipo_Sala"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Tipo_Usuario" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Tipo_Usuario"
(
	"Id" INTEGER NOT NULL,
	"Descricao" VARCHAR(50) NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Tipo_Usuario" ADD CONSTRAINT "pkTipo_Usuario"
	PRIMARY KEY ("Id");


/******************** Add Table: "Chaves"."Usuario" ************************/

/* Build Table Structure */
CREATE TABLE "Chaves"."Usuario"
(
	"Id" INTEGER NOT NULL,
	"Login" VARCHAR(50) NOT NULL,
	"Senha" VARCHAR(100) NOT NULL,
	"Pessoa_Id" INTEGER NOT NULL
);

/* Add Primary Key */
ALTER TABLE "Chaves"."Usuario" ADD CONSTRAINT "pkUsuario"
	PRIMARY KEY ("Id");





/************ Add Foreign Keys ***************/

/* Add Foreign Key: fk_Aluno_Curso */
ALTER TABLE "Chaves"."Aluno" ADD CONSTRAINT "fk_Aluno_Curso"
	FOREIGN KEY ("Curso_Id") REFERENCES "Chaves"."Curso" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Aluno_Pessoa */
ALTER TABLE "Chaves"."Aluno" ADD CONSTRAINT "fk_Aluno_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "Chaves"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Curso_Departamento */
ALTER TABLE "Chaves"."Curso" ADD CONSTRAINT "fk_Curso_Departamento"
	FOREIGN KEY ("Departamento_Id") REFERENCES "Chaves"."Departamento" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Locacao_Pessoa */
ALTER TABLE "Chaves"."Locacao" ADD CONSTRAINT "fk_Locacao_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "Chaves"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Locacao_Sala */
ALTER TABLE "Chaves"."Locacao" ADD CONSTRAINT "fk_Locacao_Sala"
	FOREIGN KEY ("Sala_Id") REFERENCES "Chaves"."Sala" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Permissao_Acao */
ALTER TABLE "Chaves"."Permissao" ADD CONSTRAINT "fk_Permissao_Acao"
	FOREIGN KEY ("Acao_Id") REFERENCES "Chaves"."Acao" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Permissao_Tipo_Usuario */
ALTER TABLE "Chaves"."Permissao" ADD CONSTRAINT "fk_Permissao_Tipo_Usuario"
	FOREIGN KEY ("Tipo_Usuario_Id") REFERENCES "Chaves"."Tipo_Usuario" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Pessoa_Usuario_Pessoa */
ALTER TABLE "Chaves"."Pessoa_Usuario" ADD CONSTRAINT "fk_Pessoa_Usuario_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "Chaves"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Pessoa_Usuario_Tipo_Usuario */
ALTER TABLE "Chaves"."Pessoa_Usuario" ADD CONSTRAINT "fk_Pessoa_Usuario_Tipo_Usuario"
	FOREIGN KEY ("Tipo_Usuario_Id") REFERENCES "Chaves"."Tipo_Usuario" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Professor_Departamento */
ALTER TABLE "Chaves"."Professor" ADD CONSTRAINT "fk_Professor_Departamento"
	FOREIGN KEY ("Departamento_Id") REFERENCES "Chaves"."Departamento" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Professor_Pessoa */
ALTER TABLE "Chaves"."Professor" ADD CONSTRAINT "fk_Professor_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "Chaves"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Reserva_Professor */
ALTER TABLE "Chaves"."Reserva" ADD CONSTRAINT "fk_Reserva_Professor"
	FOREIGN KEY ("Professor_Id") REFERENCES "Chaves"."Professor" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Reserva_Sala */
ALTER TABLE "Chaves"."Reserva" ADD CONSTRAINT "fk_Reserva_Sala"
	FOREIGN KEY ("Sala_Id") REFERENCES "Chaves"."Sala" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Reserva_Tecnico */
ALTER TABLE "Chaves"."Reserva" ADD CONSTRAINT "fk_Reserva_Tecnico"
	FOREIGN KEY ("Tecnico_Id") REFERENCES "Chaves"."Tecnico" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Sala_Pavilhao */
ALTER TABLE "Chaves"."Sala" ADD CONSTRAINT "fk_Sala_Pavilhao"
	FOREIGN KEY ("Pavilhao_Id") REFERENCES "Chaves"."Pavilhao" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Tecnico_Departamento */
ALTER TABLE "Chaves"."Tecnico" ADD CONSTRAINT "fk_Tecnico_Departamento"
	FOREIGN KEY ("Departamento_Id") REFERENCES "Chaves"."Departamento" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Tecnico_Pessoa */
ALTER TABLE "Chaves"."Tecnico" ADD CONSTRAINT "fk_Tecnico_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "Chaves"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;

/* Add Foreign Key: fk_Usuario_Pessoa */
ALTER TABLE "Chaves"."Usuario" ADD CONSTRAINT "fk_Usuario_Pessoa"
	FOREIGN KEY ("Pessoa_Id") REFERENCES "Chaves"."Pessoa" ("Id")
	ON UPDATE NO ACTION ON DELETE NO ACTION;