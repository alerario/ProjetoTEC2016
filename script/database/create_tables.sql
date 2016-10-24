--Este script para criacao das tabelas no banco de dados

CREATE TABLE public.teste
(
    codigo integer NOT NULL,
    nome character varying (70),
    CONSTRAINT pk_teste PRIMARY KEY (codigo)
);

CREATE TABLE public.categoria(
	Cod_categoria SERIAL PRIMARY KEY,
	Nome VARCHAR(50)
);

CREATE TABLE public.servico(
	Cod_servico SERIAL PRIMARY KEY,
	Descricao VARCHAR(255),
	Valor DOUBLE NOT NULL,
	Cod_categoria INTEGER,
	CONSTRAINT fk_servico_categoria foreign key (Cod_categoria) references public.categoria(Cod_categoria)
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

create table public.relatorios
(
	cod_relatorios integer NOT NULL,
	id_cliente varchar,
	id_fornecedor varchar,
	id_servico varchar NOT NULL
	descricao varchar,
	CONSTRAINT pk_relatorios primary key (cod_relatorios),
	CONSTRAINT fk_cliente foreign key (id_cliente) references pessoaFisica(cpf),
	CONSTRAINT fk_fornecedor foreign key (id_fornecedor) references pessoaJuridica(cnpj),
	CONSTRAINT fk_servico foreign key (id_servico) references servico(cod_servico)
);

create table public.pessoaJuridica
(
	cnpj varchar NOT NULL	
)inherits(cliente);

create table public.pessoaFisica
(
	cpf varchar NOT NULL	
)inherits(cliente);

create table public.servico 
(
	cod_servico varchar NOT NULL,
	valor double NOT NULL,
	categoria varchar NOT NULL,
	descricao varchar
)
