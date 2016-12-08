-- a tabela teste deve ser criada, pois temos um teste associado a ela.
-- se nao for criada, o travis acusará erro
CREATE TABLE public.teste(
    codigo integer NOT NULL,
    nome VARCHAR (70),
    CONSTRAINT pk_teste PRIMARY KEY (codigo)
);

-- categoria de servico (ok)
CREATE TABLE public.categoria(
	cod_categoria INTEGER PRIMARY KEY,
	nome VARCHAR(50)
);

-- logradouro (ajustar) - nome das tabelas em minusc. efetuar heranca em bd
CREATE TABLE public.endereco(
	cod_endereco INTEGER PRIMARY KEY NOT NULL,
	rua VARCHAR(150) NOT NULL,
	numero VARCHAR(10) NOT NULL,    
	bairro VARCHAR(50) NOT NULL,
	estado VARCHAR(10) NOT NULL,
    cidade VARCHAR(100) NOT NULL
);

-- usuario
CREATE TABLE public.usuario(
  cod_usuario serial,
  login character varying(40),
  senha character varying(40),
  email character varying(100),
  CONSTRAINT usuario_pkey PRIMARY KEY (cod_usuario)
);

-- analista de marketing, especialização de usuario
CREATE TABLE public.usuarioMarketing(
  cod_usuarioMarketing INTEGER NOT NULL,
  login character varying(40),
  senha character varying(40),
  email character varying(100),
  CONSTRAINT usuarioMarketing_pkey PRIMARY KEY (cod_usuarioMarketing)
) INHERITS (cities);

-- pessoa física -- criar como heranca de usuario
create table public.fisica(
	cod_fisica INTEGER PRIMARY KEY NOT NULL,
	nome VARCHAR(100) NOT NULL,
	cpf VARCHAR(100) NOT NULL,
	rg VARCHAR(100) NOT NULL	
);

-- pessoa juridica 
create table public.juridica(
	cod_juridica INTEGER PRIMARY KEY NOT NULL,
	razao_social VARCHAR(100) NOT NULL,
	nome_fantasia VARCHAR(100) NOT NULL,
	cnpj VARCHAR(100) NOT NULL,
	inscricao_municipal VARCHAR(100) NOT NULL	
);

-- cliente do serviço
create table public.cliente(
	cod_cliente INTEGER PRIMARY KEY NOT NULL,
    telefone VARCHAR(100),
    cpf VARCHAR(100),
	codfk_fisica INTEGER,
    codfk_endereco INTEGER,		
	CONSTRAINT fk_cliente_fisica foreign key (codfk_fisica) references public.fisica(cod_fisica),    
    CONSTRAINT fk_cliente_endereco foreign key (codfk_endereco) references public.endereco(cod_endereco)
);

-- prestador de serviço
create table public.prestador(
	cod_prestador INTEGER PRIMARY KEY NOT NULL,
    telefone VARCHAR(50),
	codfk_fisica INTEGER,
    codfk_juridica INTEGER,
	codfk_endereco INTEGER,	
	CONSTRAINT fk_prestador_fisica foreign key (codfk_fisica) references public.fisica(cod_fisica),
	CONSTRAINT fk_prestador_juridica foreign key (codfk_juridica) references public.juridica(cod_juridica),    
	CONSTRAINT fk_prestador_endereco foreign key (codfk_endereco) references public.endereco(cod_endereco)
);

-- serviço
CREATE TABLE public.servico(
	cod_servico INTEGER PRIMARY KEY NOT NULL,
	descricao VARCHAR(250),
	valor REAL NOT NULL,
	proposta_cliente VARCHAR(100),
	proposta_fornecedor VARCHAR(100),
	intervalo_cliente VARCHAR(100),
	intervalo_fornecedor VARCHAR(100),
	status_negociacao BOOLEAN,
    codfk_cliente INTEGER,
    codfk_prestador INTEGER, 
	codfk_categoria INTEGER,
	CONSTRAINT fk_servico_cliente foreign key (codfk_cliente) references public.cliente(cod_cliente),
	CONSTRAINT fk_servico_prestador foreign key (codfk_prestador) references public.prestador(cod_prestador),    
	CONSTRAINT fk_servico_categoria foreign key (codfk_categoria) references public.categoria(cod_categoria)
);

-- agendamento de serviço
CREATE TABLE public.agendamento(
	cod_agendamento INTEGER PRIMARY KEY,
	dia VARCHAR(50) NOT NULL,
    mes VARCHAR(50) NOT NULL,
    ano VARCHAR(50) NOT NULL,
    horas VARCHAR(50) NOT NULL,
    minutos VARCHAR(50) NOT NULL,
    duracao VARCHAR(50) NOT NULL,
    descricao VARCHAR(150),    
	codfk_servico INT NOT NULL,
	CONSTRAINT fk_agendamento_servico FOREIGN KEY (codfk_servico) REFERENCES public.servico(cod_servico)
);

-- Mensagens para suporte
CREATE TABLE public.mensagemsuporte(
	cod_mensagem integer primary key,
	assunto_mensagem varchar(100),
	resposta_mensagem varchar(1000),
	pergunta_mensagem varchar(1000),

	cod_prestador INTEGER,
	cod_cliente INTEGER,

	CONSTRAINT fk_Cod_prestador 
	FOREIGN KEY (cod_prestador) 
	REFERENCES Prestador(cod_prestador) ON DELETE CASCADE,

	CONSTRAINT fk_Cod_cliente 
	FOREIGN KEY (cod_cliente) 
	REFERENCES Cliente(cod_cliente) ON DELETE CASCADE
);

-- Relação cliente e compra de um serviço
CREATE TABLE public.clienteServico(
	
	cod_clienteServico INTEGER primary key,
	cod_servico INTEGER,
	cod_cliente INTEGER,
	quantidade INTEGER,

	CONSTRAINT fk_Cod_servico 
	FOREIGN KEY (cod_servico) 
	REFERENCES Servico(cod_servico) ON DELETE CASCADE,

	CONSTRAINT fk_Cod_cliente 
	FOREIGN KEY (cod_cliente) 
	REFERENCES Cliente(cod_cliente) ON DELETE CASCADE
);

-- orçamento
CREATE TABLE public.orcamento(
	
	cod_orcamento INTEGER primary key,
	cod_prestador INTEGER,
	descricao VARCHAR(1000),

	CONSTRAINT fk_Cod_prestador 
	FOREIGN KEY (cod_prestador) 
	REFERENCES Servico(cod_prestador) ON DELETE CASCADE,
);

-- site_empresa
CREATE TABLE public.site_empresa(
	
	cod_servico INTEGER primary key,
	cod_prestador INTEGER primary key,

	CONSTRAINT fk_Cod_servico 
	FOREIGN KEY (cod_servico) 
	REFERENCES Servico(cod_servico) ON DELETE CASCADE,
	
	CONSTRAINT fk_Cod_prestador 
	FOREIGN KEY (cod_prestador) 
	REFERENCES Servico(cod_prestador) ON DELETE CASCADE,
);




