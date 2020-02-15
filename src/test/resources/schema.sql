CREATE TABLE IF NOT EXISTS SGS_SIMULADOS(
   SIMULADO_ID serial PRIMARY KEY, 
   DATA_SIMULADO DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS SGS_PROVAS(
   PROVA_ID serial PRIMARY KEY,
   MATERIA_ID INTEGER  NOT NULL,  
   DATA_PROVA DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE IF NOT EXISTS SGS_SIMU_PROVA (
	SIMULADO_ID INTEGER  NOT NULL,
	PROVA_ID INTEGER  NOT NULL
);

CREATE TABLE IF NOT EXISTS SGS_MATERIAS (
	MATERIA_ID serial PRIMARY KEY, 
	DESCRICAO VARCHAR (255) NOT NULL
);

CREATE TABLE IF NOT EXISTS SGS_NIVEL (
	NIVEL_ID serial PRIMARY KEY, 
	DESCRICAO VARCHAR (100) NOT NULL, 
	PONTOS INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS SGS_QUESTOES(
	QUESTAO_ID serial PRIMARY KEY, 
	ENUNCIADO VARCHAR (255) NOT NULL,
	NIVEL_ID INTEGER NOT NULL, 
	MATERIA_ID INTEGER  NOT NULL
);

CREATE TABLE IF NOT EXISTS SGS_QUES_PROVA (
	QUESTAO_ID INTEGER  NOT NULL,
	PROVA_ID INTEGER  NOT NULL
);

CREATE TABLE IF NOT EXISTS SGS_RESPOSTAS (
	RESPOSTA_ID serial PRIMARY KEY, 
	QUESTAO_ID INTEGER  NOT NULL,
	ENUNCIADO VARCHAR (255) NOT NULL
);

ALTER TABLE SGS_SIMU_PROVA DROP CONSTRAINT IF EXISTS FK_SGS_SIMU_PROVA_01;
ALTER TABLE SGS_SIMU_PROVA DROP CONSTRAINT IF EXISTS FK_SGS_SIMU_PROVA_02;
ALTER TABLE SGS_SIMU_PROVA ADD CONSTRAINT FK_SGS_SIMU_PROVA_01 FOREIGN KEY (SIMULADO_ID) REFERENCES SGS_SIMULADOS (SIMULADO_ID); 
ALTER TABLE SGS_SIMU_PROVA ADD CONSTRAINT FK_SGS_SIMU_PROVA_02 FOREIGN KEY (PROVA_ID) REFERENCES SGS_PROVAS (PROVA_ID);


ALTER TABLE SGS_SIMU_PROVA DROP CONSTRAINT IF EXISTS FK_SGS_QUES_PROVA_01;
ALTER TABLE SGS_SIMU_PROVA DROP CONSTRAINT IF EXISTS FK_SGS_QUES_PROVA_02;
ALTER TABLE SGS_QUES_PROVA ADD CONSTRAINT FK_SGS_QUES_PROVA_01 FOREIGN KEY (QUESTAO_ID) REFERENCES SGS_QUESTOES (QUESTAO_ID);
ALTER TABLE SGS_QUES_PROVA ADD CONSTRAINT FK_SGS_QUES_PROVA_02 FOREIGN KEY (PROVA_ID) REFERENCES SGS_PROVAS (PROVA_ID);

ALTER TABLE SGS_QUESTOES DROP CONSTRAINT IF EXISTS FK_SGS_QUESTOES_01;
ALTER TABLE SGS_QUESTOES ADD CONSTRAINT FK_SGS_QUESTOES_01 FOREIGN KEY (MATERIA_ID) REFERENCES SGS_MATERIAS (MATERIA_ID);

ALTER TABLE SGS_PROVAS DROP CONSTRAINT IF EXISTS FK_SGS_PROVAS_01;
ALTER TABLE SGS_PROVAS ADD CONSTRAINT FK_SGS_PROVAS_01 FOREIGN KEY (MATERIA_ID) REFERENCES SGS_MATERIAS (MATERIA_ID);

ALTER TABLE SGS_RESPOSTAS DROP CONSTRAINT IF EXISTS FK_SGS_RESPOSTAS_01;
ALTER TABLE SGS_RESPOSTAS ADD CONSTRAINT FK_SGS_RESPOSTAS_01 FOREIGN KEY (QUESTAO_ID) REFERENCES SGS_QUESTOES (QUESTAO_ID);

	
CREATE SEQUENCE IF NOT EXISTS SGS_SIMULADOS_ID_SEQ START 1 INCREMENT 1;
CREATE SEQUENCE IF NOT EXISTS SGS_PROVAS_ID_SEQ START 1 INCREMENT 1;
CREATE SEQUENCE IF NOT EXISTS SGS_MATERIAS_ID_SEQ START 1 INCREMENT 1;
CREATE SEQUENCE IF NOT EXISTS SGS_QUESTOES_ID_SEQ START 1 INCREMENT 1;
CREATE SEQUENCE IF NOT EXISTS SGS_NIVEL_ID_SEQ START 1 INCREMENT 1;
CREATE SEQUENCE IF NOT EXISTS SGS_RESPOSTAS_ID_SEQ START 1 INCREMENT 1;



