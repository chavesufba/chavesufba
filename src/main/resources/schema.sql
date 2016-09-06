DROP SCHEMA IF EXISTS SCHEMAA;

CREATE SCHEMA SCHEMAA;

CREATE TABLE IF NOT EXISTS SCHEMAA.PAVILHAO
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	NOME VARCHAR(512) NOT NULL,
	CONSTRAINT PK_PAVILHAO PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS SCHEMAA.INSTITUTO
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	NOME VARCHAR(100) NOT NULL,
	CONSTRAINT PK_INSTITUTO PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS SCHEMAA.DEPARTAMENTO
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	NOME VARCHAR(100) NOT NULL,
	INSTITUTO_ID INTEGER NOT NULL,
	CONSTRAINT PK_DEPARTAMENTO PRIMARY KEY (ID),
	CONSTRAINT FK_DEPARTAMENTO_INSTITUTO FOREIGN KEY (INSTITUTO_ID) REFERENCES SCHEMAA.INSTITUTO(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS SCHEMAA.CURSO
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	NOME VARCHAR(100) NOT NULL,
	NIVEL VARCHAR(50) NOT NULL,
	DEPARTAMENTO_ID INTEGER NOT NULL,
	CONSTRAINT PK_CURSO PRIMARY KEY (ID),
	CONSTRAINT FK_CURSO_DEPARTAMENTO FOREIGN KEY (DEPARTAMENTO_ID) REFERENCES SCHEMAA.DEPARTAMENTO(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS SCHEMAA.SALA
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	NUMERO VARCHAR(20) NOT NULL,
	CAPACIDADE INTEGER NULL,
	PAVILHAO_ID INTEGER NOT NULL,
	TIPO VARCHAR(1) NOT NULL,
	DESCRICAO_EQUIPAMENTOS VARCHAR(255),
	CONSTRAINT PK_SALA PRIMARY KEY (ID),
	CONSTRAINT FK_SALA_PAVILHAO FOREIGN KEY (PAVILHAO_ID) REFERENCES SCHEMAA.PAVILHAO(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
);

CREATE TABLE IF NOT EXISTS SCHEMAA.TIPO_USUARIO
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	DESCRICAO VARCHAR(50) NOT NULL,
	CONSTRAINT PK_TIPO_USUARIO PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS SCHEMAA.PERMISSAO
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	TIPO_USUARIO_ID INTEGER NOT NULL,
	CONSTRAINT PK_PERMISSAO PRIMARY KEY (ID),
	CONSTRAINT FK_PERMISSAO_TIPO_USUARIO FOREIGN KEY (TIPO_USUARIO_ID) REFERENCES SCHEMAA.TIPO_USUARIO(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS SCHEMAA.PESSOA
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	NOME VARCHAR(100) NOT NULL,
	EMAIL VARCHAR(100) NOT NULL,
	TELEFONE VARCHAR(20) NULL,
	FOTO VARCHAR(250) NULL,
	LOGIN VARCHAR(100) NOT NULL,
	SENHA VARCHAR(100) NOT NULL,
	CONSTRAINT PK_PESSOA PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS SCHEMAA.TECNICO
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	DEPARTAMENTO_ID INTEGER NOT NULL,
	PESSOA_ID INTEGER NOT NULL,
	CONSTRAINT PK_TECNICO PRIMARY KEY (ID),
	CONSTRAINT FK_TECNICO_DEPARTAMENTO FOREIGN KEY (DEPARTAMENTO_ID) REFERENCES SCHEMAA.DEPARTAMENTO(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT FK_TECNICO_PESSOA FOREIGN KEY (PESSOA_ID) REFERENCES SCHEMAA.PESSOA(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS SCHEMAA.PROFESSOR
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	NUM_SIAP VARCHAR(20) NOT NULL,
	DEPARTAMENTO_ID INTEGER NOT NULL,
	PESSOA_ID INTEGER NOT NULL,
	CONSTRAINT PK_PROFESSOR PRIMARY KEY (ID),
	CONSTRAINT FK_PROFESSOR_DEPARTAMENTO FOREIGN KEY (DEPARTAMENTO_ID) REFERENCES SCHEMAA.DEPARTAMENTO(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT FK_PROFESSOR_PESSOA FOREIGN KEY (PESSOA_ID) REFERENCES SCHEMAA.PESSOA(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS SCHEMAA.USUARIO
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	LOGIN VARCHAR(50) NOT NULL,
	SENHA VARCHAR(100) NOT NULL,
	PESSOA_ID INTEGER NOT NULL REFERENCES SCHEMAA.PESSOA(ID),
	CONSTRAINT PK_USUARIO PRIMARY KEY (ID),
	CONSTRAINT FK_USUARIO_PESSOA FOREIGN KEY (PESSOA_ID) REFERENCES SCHEMAA.PESSOA(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS SCHEMAA.PESSOA_USUARIO
(
	PESSOA_ID INTEGER NOT NULL,
	TIPO_USUARIO_ID INTEGER NOT NULL,
	CONSTRAINT FK_PESSOA_USUARIO_PESSOA FOREIGN KEY (PESSOA_ID) REFERENCES SCHEMAA.PESSOA(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT FK_PESSOA_USUARIO_TIPO_USUARIO FOREIGN KEY (TIPO_USUARIO_ID) REFERENCES SCHEMAA.TIPO_USUARIO(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS SCHEMAA.ALUNO
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	MATRICULA VARCHAR(20) NOT NULL,
	PESSOA_ID INTEGER NOT NULL,
	CURSO_ID INTEGER NOT NULL,
	CONSTRAINT PK_ALUNO PRIMARY KEY (ID),
	CONSTRAINT FK_ALUNO_PESSOA FOREIGN KEY (PESSOA_ID) REFERENCES SCHEMAA.PESSOA(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT FK_ALUNO_CURSO FOREIGN KEY (CURSO_ID) REFERENCES SCHEMAA.CURSO(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS SCHEMAA.RESERVA
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	PROFESSOR_ID INTEGER,
	SALA_ID INTEGER NOT NULL,
	HORA_INICIO TIMESTAMP NULL,
	HORA_FINAL TIMESTAMP NULL,
	TECNICO_ID INTEGER NULL,
	STATUS VARCHAR(1) NULL,
	CONSTRAINT PK_RESERVA PRIMARY KEY (ID),
	CONSTRAINT FK_RESERVA_PROFESSOR FOREIGN KEY (PROFESSOR_ID) REFERENCES SCHEMAA.PROFESSOR(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT FK_RESERVA_SALA FOREIGN KEY (SALA_ID) REFERENCES SCHEMAA.SALA(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT FK_RESERVA_TECNICO FOREIGN KEY (TECNICO_ID) REFERENCES SCHEMAA.TECNICO(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS SCHEMAA.LOCACAO
(
	ID INTEGER NOT NULL AUTO_INCREMENT,
	ALUNO_ID INTEGER NOT NULL,
	SALA_ID INTEGER NOT NULL,
	HORA_INICIO TIMESTAMP NULL,
	HORA_FINAL TIMESTAMP NULL,
	CONSTRAINT PK_LOCACAO PRIMARY KEY (ID),
	CONSTRAINT FK_LOCACAO_ALUNO FOREIGN KEY (ALUNO_ID) REFERENCES SCHEMAA.ALUNO(ID) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT FK_LOCACAO_SALA FOREIGN KEY (SALA_ID) REFERENCES SCHEMAA.SALA(ID) ON UPDATE NO ACTION ON DELETE NO ACTION
);

