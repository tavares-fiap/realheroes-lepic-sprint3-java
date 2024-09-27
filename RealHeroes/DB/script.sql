DROP DATABASE REALHEROES;
CREATE DATABASE REALHEROES;
USE REALHEROES;

CREATE TABLE TUTOR
(
    cpf VARCHAR(11),
    name VARCHAR(50),
    email VARCHAR(30),
    address VARCHAR(70),
    password VARCHAR(20),
    PRIMARY KEY (cpf)
);

INSERT INTO TUTOR (cpf, name, email, address, password)
VALUES ('12345678910', 'Pedro Tavares', 'exemplo@gmail.com', 'Rua dos Carurus 879', '123456');

SELECT * FROM TUTOR;