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
	cod_cliente integer NOT NULL,
	nome varchar NOT NULL,
	telefone varchar NOT NULL,
	rua varchar,
	numero varchar,
	bairro varchar,
	cidade varchar,
	estado varchar,	
	CONSTRAINT pk_cliente primary key (cod_cliente)
);

create table public.pessoaJuridica
(

	cnpj varchar NOT NULL
	
)inherits(cliente);

create table public.pessoaFisica
(

	cpf varchar NOT NULL
	
)inherits(cliente);


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


/* ? Já existe a tabela serviço
create table public.servico 
(
	cod_servico varchar NOT NULL,
	valor double NOT NULL,
	categoria varchar NOT NULL,
	descricao varchar
)
*/

create table public.agendamento
(
	cod_agendamento serial PRIMARY KEY,
	dia INT NOT NULL,
	mes INT NOT NULL,
	ano INT NOT NULL,
	horas INT NOT NULL,
	minutos INT NOT NULL,
	duracao INT NOT NULL,
	servico INT NOT NULL,
	CONSTRAINT fk_servico_agendamento FOREIGN KEY (servico) REFERENCES public.servico(Cod_servico)
);


create table public.prestadorServico(
	cod_prestador double not null,
	endereco_fk double REFERENCES endereco,
	telefone varchar,
	primary key(cod_prestaador)
);

create table public.fisica(
	nome varchar not null,
	cpf varchar not null,
	rg varchar not null,
	UNIQUE(cpf)
)inherits(prestadorServico);

create table public.juridica(
	razaoSocial varchar not null,
	nomeFantasia varchar not null,
	cnpj varchar not null,
	inscricaoMunicipal varchar not null,
	UNIQUE(cnpj)
)inherits(prestradorServico;


