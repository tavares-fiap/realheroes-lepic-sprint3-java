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

CREATE TABLE DEVICE
(
   IDdevice INT(3),
   Description VARCHAR(70) NOT NULL,
   Marca VARCHAR (10),
   PRIMARY KEY (IDdevice)
);

CREATE TABLE STOCK
(
   IDdevice INT(3),
   cpf_residente VARCHAR(11),
   DataRT DATE NOT NULL,
   DataDev DATE,
   PRIMARY KEY (IDdevice, cpf_residente, DataRT),
   FOREIGN KEY (IDdevice) REFERENCES DEVICE(IDdevice),
   FOREIGN KEY (cpf_residente) REFERENCES RESIDENT(cpf)
);

INSERT INTO TUTOR (cpf, name, email, address, password)
VALUES ('12345678910', 'Pedro Tavares', 'exemplo@gmail.com', 'Rua dos Carurus 879', '123456');

INSERT INTO TUTOR (cpf, name, email, address, password)
VALUES ('98765432100', 'Ana Luiza', 'ana_luiza@gmail.com', 'Av. Paulista 1000', 'senha123');

INSERT INTO TUTOR (cpf, name, email, address, password)
VALUES ('11223344556', 'João Silva', 'joao_silva@gmail.com', 'Rua Flores 123', 'joao2024');

INSERT INTO TUTOR (cpf, name, email, address, password)
VALUES ('22334455668', 'Maria Oliveira', 'maria_oliveira@gmail.com', 'Rua Santos 400', 'maria5678');

INSERT INTO TUTOR (cpf, name, email, address, password)
VALUES ('33445566779', 'Carlos Pereira', 'carlos_pereira@gmail.com', 'Rua das Palmeiras 250', 'carlinhos321');

INSERT INTO TUTOR (cpf, name, email, address, password)
VALUES ('44556677880', 'Beatriz Souza', 'bia_souza@gmail.com', 'Av. Central 888', 'bia2024');



INSERT INTO RESIDENT (cpf, name, email, address, password, cpf_tutor)
VALUES ('12345678911', 'Carlinhos Brau', 'exemplo@gmail.com', 'Rua dos Jbiros 999', '123456', '12345678910');

INSERT INTO RESIDENT (cpf, name, email, address, password, cpf_tutor)
VALUES ('22334455667', 'Joana Costa', 'joana_costa@gmail.com', 'Rua das Margaridas 999', 'joana9876', '98765432100');

INSERT INTO RESIDENT (cpf, name, email, address, password, cpf_tutor)
VALUES ('33445566778', 'Marcos Tavares', 'marcos_tavares@gmail.com', 'Rua dos Pardais 500', 'marcos2024', '11223344556');

INSERT INTO RESIDENT (cpf, name, email, address, password, cpf_tutor)
VALUES ('44556677889', 'Luiza Rocha', 'luiza_rocha@gmail.com', 'Av. Verde 600', 'luiza2024', '22334455668');

INSERT INTO RESIDENT (cpf, name, email, address, password, cpf_tutor)
VALUES ('55667788990', 'Rodrigo Nunes', 'rodrigo_nunes@gmail.com', 'Rua do Sol 150', 'rodrigo2024', '334455667796');

INSERT INTO RESIDENT (cpf, name, email, address, password, cpf_tutor)
VALUES ('66778899001', 'Amanda Borges', 'amanda_borges@gmail.com', 'Rua das Estrelas 200', 'amanda2024', '44556677880');



INSERT INTO TRAIN (IDattempt, score, position, cpf_residente) 
VALUES (1, 85, 1, '12345678911');

INSERT INTO TRAIN (IDattempt, score, position, cpf_residente) 
VALUES (2, 75, 2, '22334455667');

INSERT INTO TRAIN (IDattempt, score, position, cpf_residente) 
VALUES (3, 90, 1, '33445566778');

INSERT INTO TRAIN (IDattempt, score, position, cpf_residente) 
VALUES (4, 65, 3, '44556677889');

INSERT INTO TRAIN (IDattempt, score, position, cpf_residente) 
VALUES (5, 85, 2, '55667788990');

INSERT INTO TRAIN (IDattempt, score, position, cpf_residente) 
VALUES (6, 95, 1, '66778899001');



INSERT INTO GAME_PHASE (IDSelectedPhase, phaseName, Dificulty)
VALUES (1, 'Fase 1', 'easy');

INSERT INTO GAME_PHASE (IDSelectedPhase, phaseName, Dificulty)
VALUES (2, 'Fase 2', 'medium');

INSERT INTO GAME_PHASE (IDSelectedPhase, phaseName, Dificulty)
VALUES (3, 'Fase 3', 'hard');

INSERT INTO GAME_PHASE (IDSelectedPhase, phaseName, Dificulty)
VALUES (4, 'Fase 4', 'professional');

INSERT INTO GAME_PHASE (IDSelectedPhase, phaseName, Dificulty)
VALUES (5, 'Fase 5', 'easy');

INSERT INTO GAME_PHASE (IDSelectedPhase, phaseName, Dificulty)
VALUES (6, 'Fase 6', 'medium');


INSERT INTO PHASE_TRAIN (IDattempt, IDSelectedPhase, date_of_completion, completion_time) 
VALUES (1, 1, '2024-09-28', '01:30:45');

INSERT INTO PHASE_TRAIN (IDattempt, IDSelectedPhase, feedback, date_of_completion, completion_time) 
VALUES (2, 2, 'Bom desempenho', '2024-09-29', '01:35:20');

INSERT INTO PHASE_TRAIN (IDattempt, IDSelectedPhase, feedback, date_of_completion, completion_time) 
VALUES (3, 3, 'Excelente precisão', '2024-09-30', '01:50:10');

INSERT INTO PHASE_TRAIN (IDattempt, IDSelectedPhase, feedback, date_of_completion, completion_time) 
VALUES (4, 4, 'Ótima performance', '2024-10-01', '01:45:05');

INSERT INTO PHASE_TRAIN (IDattempt, IDSelectedPhase, feedback, date_of_completion, completion_time) 
VALUES (5, 5, 'Desempenho satisfatório', '2024-10-02', '02:10:00');

INSERT INTO PHASE_TRAIN (IDattempt, IDSelectedPhase, feedback, date_of_completion, completion_time) 
VALUES (6, 6, 'Superou as expectativas', '2024-10-03', '02:20:30');

INSERT INTO DEVICE VALUES(1, "Oculus Quest 3 128 GB Advanced All-in-One", "Meta");
INSERT INTO DEVICE VALUES(2, "Oculus Quest 3 512 GB Advanced All-in-One", "Meta");
INSERT INTO DEVICE VALUES(3, "Oculus Quest 2 128 GB Advanced All-in-One", "Meta");

INSERT INTO STOCK VALUES(1, 12345678911, '2024-09-13', '2024-09-28');
INSERT INTO STOCK VALUES(2, 22334455667, '2024-09-28', '2024-07-20');
INSERT INTO STOCK VALUES(2, 12345678911, '2024-07-05', '2024-10-13');

SELECT * FROM TUTOR;
SELECT * FROM RESIDENT;
SELECT * FROM TRAIN;
SELECT * FROM GAME_PHASE;
SELECT * FROM PHASE_TRAIN;
SELECT * FROM DEVICE;
SELECT * FROM STOCK;