-- --
-- -- SALA
-- --

CREATE TABLE "schemaA"."sala"
(
	"id" INTEGER NOT NULL,
	"numero" VARCHAR(20) NOT NULL,
	"capacidade" INTEGER NULL,
	"pavilhao_id" INTEGER NULL,
	"tipo_sala_id" INTEGER NULL
);

ALTER TABLE "schemaA"."sala" ADD CONSTRAINT "pkSala"
	PRIMARY KEY ("id");

insert into "schemaA.sala" (numero, capacidade, pavilhao_id, tipo_sala_id) values ("123", 15, 1, 2)
insert into "schemaA.sala" (numero, capacidade, pavilhao_id, tipo_sala_id) values ("456", 15, 1, 2)
insert into "schemaA.sala" (numero, capacidade, pavilhao_id, tipo_sala_id) values ("789", 15, 1, 2)

