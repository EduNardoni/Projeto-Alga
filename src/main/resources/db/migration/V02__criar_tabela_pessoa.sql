CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Eduardo', 'Rua A', '7', 'Apto 33', 'Bairro01', '11111-111', 'São Paulo', 'SP', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Maria', 'Rua B', '2', 'Casa 2', 'Bairro02', '22222-222', 'Belo Horizonte', 'MG', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Lucas', 'Rua C', '11', null, 'Bairro03', '33333-333', 'Rio de Janeiro', 'RJ', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('João', 'Rua D', '187', null, 'Bairro04', '44444-444', 'Rio Grande do Sul', 'RS', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Thiago', 'Rua E', '63', 'Casa 132', 'Bairro05', '55555-555', 'Mogi das Cruzes', 'SP', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Rafael', 'Rua F', '256', 'Casa 171', 'Bairro06', '66666-666', 'Osasco', 'SP', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Julia', 'Rua G', '98', 'Apto 2B', 'Bairro07', '77777-777', 'Guarulhos', 'SP', true);
INSERT INTO pessoa (nome, logradouro, numero, complemento, bairro, cep, cidade, estado, ativo) values ('Alessandra', 'Rua H', '44', 'Apto 9C', 'Bairro08', '88888-888', 'Mogi das Cruzes', 'SP', true);
