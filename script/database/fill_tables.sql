-- script para popular o banco. 
-- Pode ser utilizado nos testes ou novos scrips para populacao poderao ser criados
-- Caso não tenha crud, um conjunto basico de registros deve ser adicionado a tabela. Utilize este script para isso

---------------------------------------------
--TABELA TESTE

INSERT INTO public.teste(codigo, nome) VALUES (1, 'Alexandre L''Erario');
INSERT INTO public.teste(codigo, nome) VALUES (2, 'Maria');
INSERT INTO public.teste(codigo, nome) VALUES (3, 'Paula');
INSERT INTO public.teste(codigo, nome) VALUES (4, 'Donato');
INSERT INTO public.teste(codigo, nome) VALUES (5, 'Rita');
INSERT INTO public.teste(codigo, nome) VALUES (6, 'Silvia');


-------------------------------------------
--Tabela Cliente

INSERT INTO public.pessoaJuridica(cod_cliente, nome, telefone, rua, numero, bairro, cidade, estado, cnpj) values (1, "Coca-Pepsi", "98542569", "Rua 1", "251", "Centro", "Londrina", "Parana", "07123456000110123456000110");
INSERT INTO public.pessoaJuridica(cod_cliente, nome, telefone, rua, numero, bairro, cidade, estado, cnpj) values (2, "Burguer Donalds", "99577569", "Rua 2", "252", "Centro", "Sao Paulo", "Sao Paulo", "04123458000110000110");
INSERT INTO public.pessoaJuridica(cod_cliente, nome, telefone, rua, numero, bairro, cidade, estado, cnpj) values (3, "Mc Bobs", "99542569", "Rua 3", "230", "Centro", "Ibipora", "Parana", "04123456000118");
INSERT INTO public.pessoaJuridica(cod_cliente, nome, telefone, rua, numero, bairro, cidade, estado, cnpj) values (4, "Idroid", "99542561", "Rua 4", "253", "Centro", "Londrina", "Parana", "04123456000117");
INSERT INTO public.pessoaJuridica(cod_cliente, nome, telefone, rua, numero, bairro, cidade, estado, cnpj) values (5, "Nestle", "99534666", "Rua 5", "254", "Centro", "Curitiba", "Parana", "04123456000116");

INSERT INTO public.pessoaFisica(cod_cliente, nome, telefone, rua, numero, bairro, cidade, estado, cnpj) values (1, "Joao", "99547769", "Rua 80", "2120", "Centro", "Londrina", "Parana", "01234521410");
INSERT INTO public.pessoaFisica(cod_cliente, nome, telefone, rua, numero, bairro, cidade, estado, cnpj) values (2, "Joana", "97542569", "Rua 81", "2850", "Centro", "Sao Paulo", "Sao Paulo", "01234521411");
INSERT INTO public.pessoaFisica(cod_cliente, nome, telefone, rua, numero, bairro, cidade, estado, cnpj) values (3, "Joaquim", "97742569", "Rua 51", "240", "Centro", "Rio de Janeiro", "Rio de Janeiro", "01234521412");
INSERT INTO public.pessoaFisica(cod_cliente, nome, telefone, rua, numero, bairro, cidade, estado, cnpj) values (4, "Jose", "99582569", "Rua 311", "258", "Centro", "Londrina", "Parana", "01234521413");
INSERT INTO public.pessoaFisica(cod_cliente, nome, telefone, rua, numero, bairro, cidade, estado, cnpj) values (5, "Josefa", "99342569", "Rua 14", "20", "Centro", "Curitiba", "Parana", "01234521414");

