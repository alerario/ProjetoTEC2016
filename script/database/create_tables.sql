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

create table public.negociacao
(
	cod_negociacao integer NOT NULL,
	id_cliente varchar NOT NULL,
	id_fornecedor varchar NOT NULL
	proposta_cliente varchar,
	proposta_fornecedor varchar,
	intervalo_cliente varchar,
	intervalo_fornecedor varchar,
	status_negociacao boolean,
	CONSTRAINT pk_negociacao primary key (cod_negociacao),
	CONSTRAINT fk_cliente foreign key (id_cliente) references pessoaFisica(cpf),
	CONSTRAINT fk_fornecedor foreign key (id_fornecedor) references pessoaJuridica(cnpj)
	
);

create table public.pessoaJuridica
(

	cnpj varchar NOT NULL
	
)inherits(cliente);

create table public.pessoaFisica
(

	cpf varchar NOT NULL
	
)inherits(cliente);
