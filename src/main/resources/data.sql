

INSERT INTO ADVOGADO(primeiro_nome, ultimo_nome, email, oab, uf) VALUES ('Victor', 'Ramide', 'victorramide@gmail.com', '52453', 'BA');
INSERT INTO ADVOGADO(primeiro_nome, ultimo_nome, email, oab, uf) VALUES ('João', 'Souza', 'eusoujoao@gmail.com', '88745', 'BA');
INSERT INTO ADVOGADO(primeiro_nome, ultimo_nome, email, oab, uf) VALUES ('Maria', 'Carvalho', 'maria.carvalho@gmail.com', '23555', 'BA');


INSERT INTO DILIGENCIA(processo, classe, tipo_de_diligencia, comentario, prioridade, data_da_diligencia, data_da_conclusao, advogado_id) VALUES ('8000455-25.2018.8.05.0001', 'Alimentos', 'Decisao', 'Requer deferimento da liminar', true, '2022-01-19 14:00:00', '2019-05-05 20:00:00', 1);
INSERT INTO DILIGENCIA(processo, classe, tipo_de_diligencia, comentario, prioridade, data_da_diligencia, data_da_conclusao, advogado_id) VALUES ('8002596-00.2020.8.05.0001', 'Busca e Apreensão', 'Despacho', 'Requer a citação do réu', false, '2022-01-19 14:00:00', '2020-05-05 20:00:00', 3);
INSERT INTO DILIGENCIA(processo, classe, tipo_de_diligencia, comentario, prioridade, data_da_diligencia, data_da_conclusao, advogado_id) VALUES ('8000778-05.2021.8.05.0001', 'Divorcio', 'Sentenca', 'Requer a sentença do processo com urgência parte idosa', true, '2022-01-19 14:00:00', '2019-05-05 20:00:00', 2);

