INSERT INTO SGS_SIMULADOS (SIMULADO_ID, DATA_SIMULADO) VALUES (1, DEFAULT);

INSERT INTO SGS_MATERIAS (MATERIA_ID, DESCRICAO ) VALUES (1, 'Biologia'); 
INSERT INTO SGS_MATERIAS (MATERIA_ID, DESCRICAO ) VALUES (2, 'Matemática'); 
INSERT INTO SGS_MATERIAS (MATERIA_ID, DESCRICAO ) VALUES (3, 'Física'); 

INSERT INTO SGS_PROVAS (PROVA_ID, MATERIA_ID, DATA_PROVA) VALUES (1, 1, DEFAULT);
INSERT INTO SGS_PROVAS (PROVA_ID, MATERIA_ID, DATA_PROVA) VALUES (2, 2, DEFAULT);
INSERT INTO SGS_PROVAS (PROVA_ID, MATERIA_ID, DATA_PROVA) VALUES (3, 3, DEFAULT);

INSERT INTO SGS_SIMU_PROVA (SIMULADO_ID, PROVA_ID) VALUES (1, 1);
INSERT INTO SGS_SIMU_PROVA (SIMULADO_ID, PROVA_ID) VALUES (1, 2);
INSERT INTO SGS_SIMU_PROVA (SIMULADO_ID, PROVA_ID) VALUES (1, 3);


INSERT INTO SGS_NIVEL (NIVEL_ID, DESCRICAO, PONTOS) VALUES (1, 'Fácil', 15);
INSERT INTO SGS_NIVEL (NIVEL_ID, DESCRICAO, PONTOS) VALUES (2, 'Média', 12);
INSERT INTO SGS_NIVEL (NIVEL_ID, DESCRICAO, PONTOS) VALUES (3, 'Difícil', 8);

-- BIOLOGIA
INSERT INTO SGS_QUESTOES (QUESTAO_ID, MATERIA_ID,  ENUNCIADO, NIVEL_ID) VALUES (1, 1, 'Questao 1', 1 );
INSERT INTO SGS_QUESTOES (QUESTAO_ID, MATERIA_ID,  ENUNCIADO, NIVEL_ID) VALUES (2, 1, 'Questao 2', 1 );
INSERT INTO SGS_QUESTOES (QUESTAO_ID, MATERIA_ID,  ENUNCIADO, NIVEL_ID) VALUES (3, 1, 'Questao 3', 3 );
-- MATEMATICA
INSERT INTO SGS_QUESTOES (QUESTAO_ID, MATERIA_ID,  ENUNCIADO, NIVEL_ID) VALUES (4, 2, 'Questao 1', 1 );
INSERT INTO SGS_QUESTOES (QUESTAO_ID, MATERIA_ID,  ENUNCIADO, NIVEL_ID) VALUES (5, 2, 'Questao 2', 2 );
INSERT INTO SGS_QUESTOES (QUESTAO_ID, MATERIA_ID,  ENUNCIADO, NIVEL_ID) VALUES (6, 2, 'Questao 3', 3 );
-- FÍSICA
INSERT INTO SGS_QUESTOES (QUESTAO_ID, MATERIA_ID,  ENUNCIADO, NIVEL_ID) VALUES (7, 3, 'Questao 1', 3 );
INSERT INTO SGS_QUESTOES (QUESTAO_ID, MATERIA_ID,  ENUNCIADO, NIVEL_ID) VALUES (8, 3, 'Questao 2', 3 );
INSERT INTO SGS_QUESTOES (QUESTAO_ID, MATERIA_ID,  ENUNCIADO, NIVEL_ID) VALUES (9, 3, 'Questao 3', 3 );

INSERT INTO SGS_RESPOSTAS (RESPOSTA_ID, QUESTAO_ID, ENUNCIADO) VALUES (1, 1, 'Resposta a para a questão 1 da prova de biologia');
INSERT INTO SGS_RESPOSTAS (RESPOSTA_ID, QUESTAO_ID, ENUNCIADO) VALUES (2, 1, 'Resposta b para a questão 1 da prova de biologia');
INSERT INTO SGS_RESPOSTAS (RESPOSTA_ID, QUESTAO_ID, ENUNCIADO) VALUES (3, 1, 'Resposta c para a questão 1 da prova de biologia');
INSERT INTO SGS_RESPOSTAS (RESPOSTA_ID, QUESTAO_ID, ENUNCIADO) VALUES (4, 1, 'Resposta d para a questão 1 da prova de biologia');
INSERT INTO SGS_RESPOSTAS (RESPOSTA_ID, QUESTAO_ID, ENUNCIADO) VALUES (5, 1, 'Resposta e para a questão 1 da prova de biologia');

INSERT INTO SGS_QUES_PROVA (QUESTAO_ID, PROVA_ID) VALUES (1, 1);
INSERT INTO SGS_QUES_PROVA (QUESTAO_ID, PROVA_ID) VALUES (2, 1);
INSERT INTO SGS_QUES_PROVA (QUESTAO_ID, PROVA_ID) VALUES (3, 1);

INSERT INTO SGS_QUES_PROVA (QUESTAO_ID, PROVA_ID) VALUES (4, 2);
INSERT INTO SGS_QUES_PROVA (QUESTAO_ID, PROVA_ID) VALUES (5, 2);
INSERT INTO SGS_QUES_PROVA (QUESTAO_ID, PROVA_ID) VALUES (6, 2);

INSERT INTO SGS_QUES_PROVA (QUESTAO_ID, PROVA_ID) VALUES (7, 3);
INSERT INTO SGS_QUES_PROVA (QUESTAO_ID, PROVA_ID) VALUES (8, 3);
INSERT INTO SGS_QUES_PROVA (QUESTAO_ID, PROVA_ID) VALUES (9, 3);

INSERT INTO SGS_GABARITO (GABARITO_ID, PROVA_ID) VALUES (1, 1);
INSERT INTO SGS_GABARITO (GABARITO_ID, PROVA_ID) VALUES (2, 2);
INSERT INTO SGS_GABARITO (GABARITO_ID, PROVA_ID) VALUES (3, 3);



