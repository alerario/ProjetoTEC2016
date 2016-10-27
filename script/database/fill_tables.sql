-- script para popular o banco. 
-- Pode ser utilizado nos testes ou novos scrips para populacao poderao ser criados
-- Caso não tenha crud, um conjunto basico de registros deve ser adicionado a tabela. Utilize este script para isso


-- TABELA TESTE

INSERT INTO public.teste(codigo, nome) VALUES (1, 'Alexandre L''Erario');
INSERT INTO public.teste(codigo, nome) VALUES (2, 'Maria');
INSERT INTO public.teste(codigo, nome) VALUES (3, 'Paula');


-- Tabela Categoria

INSERT INTO public.categoria(cod_categoria, nome) VALUES (1, 'Auditoria');
INSERT INTO public.categoria(cod_categoria, nome) VALUES (2, 'Consultoria');
INSERT INTO public.categoria(cod_categoria, nome) VALUES (3, 'Viagem');


-- Tabela Endereço

INSERT INTO public.endereco(cod_endereco, rua, numero, bairro, estado, cidade) VALUES (1, 'Rua y', '123', 'centro', 'pr', 'sao paulo');
INSERT INTO public.endereco(cod_endereco, rua, numero, bairro, estado, cidade) VALUES (2, 'Rua x', '3223', 'litoral', 'sp', 'sao caetano');
INSERT INTO public.endereco(cod_endereco, rua, numero, bairro, estado, cidade) VALUES (3, 'Rua z', '12223', 'lolz', 'sc', 'sao bento');


-- Tabela Fisica

INSERT INTO public.fisica(cod_fisica, nome, cpf, rg) VALUES (1, 'Joao', '100000', '011111');
INSERT INTO public.fisica(cod_fisica, nome, cpf, rg) VALUES (2, 'Marcio', '222221', '122222');
INSERT INTO public.fisica(cod_fisica, nome, cpf, rg) VALUES (3, 'Carlos', '333331', '133333');


-- Tabela Juridica

INSERT INTO public.juridica(cod_juridica, razao_social, nome_fantasia, cnpj, inscricao_municipal) values (1, 'Seila1', 'Coca Cola1', '1211132113', 'Centro');
INSERT INTO public.juridica(cod_juridica, razao_social, nome_fantasia, cnpj, inscricao_municipal) values (2, 'Seila2', 'Coca Cola2', '122222113', 'Centro');
INSERT INTO public.juridica(cod_juridica, razao_social, nome_fantasia, cnpj, inscricao_municipal) values (3, 'Seila3', 'Coca Cola3', '13232113', 'Centro');


-- Tabela Cliente

INSERT INTO public.cliente(cod_cliente, telefone, codfk_fisica, codfk_endereco) VALUES (1, '12332', 1, 1);
INSERT INTO public.cliente(cod_cliente, telefone, codfk_fisica, codfk_endereco) VALUES (2, '12232', 3, 3);
INSERT INTO public.cliente(cod_cliente, telefone, codfk_fisica, codfk_endereco) VALUES (3, '33332', 2, 2);


-- Tabela Prestador

INSERT INTO public.prestador(cod_prestador, telefone, codfk_juridica, codfk_endereco) VALUES (1, '123321', '2', '1');
INSERT INTO public.prestador(cod_prestador, telefone, codfk_fisica, codfk_endereco) VALUES (2, '123321', '1', '1');
INSERT INTO public.prestador(cod_prestador, telefone, codfk_fisica, codfk_juridica, codfk_endereco) VALUES (3, '123321', '1', '2', '1');

 
-- Tabela Servico

INSERT INTO public.servico(cod_servico, descricao, valor, codfk_categoria, codfk_cliente, codfk_prestador) VALUES(1, 'Declaração do Imposto de Renda1', "120", 1, 1, 1);
INSERT INTO public.servico(cod_servico, descricao, valor, codfk_categoria, codfk_cliente, codfk_prestador) VALUES(2, 'Declaração do Imposto de Renda1', "120", 2, 2, 3);
INSERT INTO public.servico(cod_servico, descricao, valor, codfk_categoria, codfk_cliente, codfk_prestador) VALUES(3, 'Declaração do Imposto de Renda1', "120", 3, 3, 3);

-- Tabela Agendamento
INSERT INTO public.agendamento(cod_agendamento, dia, mes, ano, horas, minutos, duracao, codfk_servico) VALUES (1, 25, 10, 2016, 15, 30, 30, 1);
INSERT INTO public.agendamento(cod_agendamento, dia, mes, ano, horas, minutos, duracao, codfk_servico) VALUES (2, 25, 10, 2016, 15, 30, 30, 2);
INSERT INTO public.agendamento(cod_agendamento, dia, mes, ano, horas, minutos, duracao, codfk_servico) VALUES (3, 25, 10, 2016, 15, 30, 30, 3);






