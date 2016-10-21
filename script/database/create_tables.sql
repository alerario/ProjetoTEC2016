--Este script para criacao das tabelas no banco de dados

CREATE TABLE public.teste
(
    codigo integer NOT NULL,
    nome character varying (70),
    CONSTRAINT pk_teste PRIMARY KEY (codigo)
);

create table public.cliente
(
	cod_client integer NOT NULL,
	nome varchar NOT NULL,
	telefone varchar NOT NULL,
	rua varchar,
	numero varchar,
	bairro varchar,
	cidade varchar,
	estado varchar,	
	CONSTRAINT pk_cliente primary key (codigo)
);

create table public.pessoaJuridica
(

	cnpj varchar NOT NULL
	
)inherits(cliente);

create table public.pessoaFisica
(

	cpf varchar NOT NULL
	
)inherits(cliente);
