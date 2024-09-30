DROP DATABASE REALHEROES;
CREATE DATABASE REALHEROES;
USE REALHEROES;

CREATE TABLE TUTOR
(
    cpf VARCHAR(11),
    name VARCHAR(50) NOT NULL,
    email VARCHAR(30),
    address VARCHAR(70),
    password VARCHAR(20) NOT NULL,
    PRIMARY KEY (cpf)
);

CREATE TABLE RESIDENT
(
    cpf VARCHAR(11),
    name VARCHAR(50) NOT NULL,
    email VARCHAR(30),
    address VARCHAR(70),
    password VARCHAR(20) NOT NULL,
    cpf_tutor VARCHAR(11) NOT NULL,
    PRIMARY KEY (cpf),
    FOREIGN KEY (cpf_tutor) REFERENCES TUTOR(cpf)
);

CREATE TABLE TRAIN 
(
    IDattempt INT(3),
    score INT(3) NOT NULL,
    position INT(3) NOT NULL,
    cpf_residente VARCHAR(11),
    PRIMARY KEY (IDattempt),
    FOREIGN KEY (cpf_residente) REFERENCES RESIDENT(cpf) ON DELETE CASCADE
);

CREATE TABLE GAME_PHASE
(
    IDSelectedPhase INT(3),
    phaseName VARCHAR(20) NOT NULL,
    Dificulty VARCHAR(20) NOT NULL,
    PRIMARY KEY (IDSelectedPhase),
    CONSTRAINT chk_dificulty CHECK (Dificulty IN ('easy', 'medium', 'hard', 'professional'))
);

CREATE TABLE PHASE_TRAIN
(
   IDattempt INT(3),
   IDSelectedPhase INT(3),
   feedback VARCHAR(255),
   date_of_completion DATE,
   completion_time TIME, 
   PRIMARY KEY (IDattempt, IDSelectedPhase),
   FOREIGN KEY (IDattempt) REFERENCES TRAIN(IDattempt) ON DELETE CASCADE,
   FOREIGN KEY (IDSelectedPhase) REFERENCES GAME_PHASE(IDSelectedPhase)
);


INSERT INTO TUTOR (cpf, name, email, address, password)
VALUES ('12345678910', 'Pedro Tavares', 'exemplo@gmail.com', 'Rua dos Carurus 879', '123456');

INSERT INTO RESIDENT (cpf, name, email, address, password, cpf_tutor)
VALUES ('12345678911', 'Carlinhos Brau', 'exemplo@gmail.com', 'Rua dos Jbiros 999', '123456', '12345678910');

INSERT INTO TRAIN (IDattempt, score, position, cpf_residente) 
VALUES (1, 85, 1, '12345678911');

INSERT INTO GAME_PHASE (IDSelectedPhase, phaseName, Dificulty)
VALUES (1, 'Fase 1', 'easy');

INSERT INTO PHASE_TRAIN (IDattempt, IDSelectedPhase, date_of_completion, completion_time) 
VALUES (1, 1, '2024-09-28', '01:30:45');

SELECT * FROM TUTOR;
SELECT * FROM RESIDENT;
SELECT * FROM TRAIN;
SELECT * FROM GAME_PHASE;
SELECT * FROM PHASE_TRAIN;