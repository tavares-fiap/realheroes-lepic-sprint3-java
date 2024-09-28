DROP DATABASE REALHEROES;
CREATE DATABASE REALHEROES;
USE REALHEROES;

CREATE TABLE TUTOR
(
    cpf VARCHAR(11),
    name VARCHAR(50) NOT NULL,
    email VARCHAR(30),
    address VARCHAR(70),
    password VARCHAR(20),
    PRIMARY KEY (cpf)
);

CREATE TABLE RESIDENT
(
    cpf VARCHAR(11),
    name VARCHAR(50) NOT NULL,
    email VARCHAR(30),
    address VARCHAR(70),
    password VARCHAR(20),
    cpf_tutor VARCHAR(11) NOT NULL,
    PRIMARY KEY (cpf),
    FOREIGN KEY (cpf_tutor) REFERENCES TUTOR(cpf)
);

INSERT INTO TUTOR (cpf, name, email, address, password)
VALUES ('12345678910', 'Pedro Tavares', 'exemplo@gmail.com', 'Rua dos Carurus 879', '123456');

INSERT INTO RESIDENT (cpf, name, email, address, password, cpf_tutor)
VALUES ('12345678911', 'Carlinhos Brau', 'exemplo@gmail.com', 'Rua dos Jbiros 999', '123456', '12345678910');

SELECT * FROM TUTOR;
SELECT * FROM RESIDENT;