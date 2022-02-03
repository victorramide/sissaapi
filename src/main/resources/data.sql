

INSERT INTO ADVOGADO(primeiro_nome, ultimo_nome, email, senha, oab, uf) VALUES ('Victor', 'Ramide', 'victorramide@gmail.com','$2a$12$zOxbc3KtPbKmHqEFMnWgfOVFdyMq5MreX7ZQM9snN7Rbv8hWfAya6', '52453', 'BA');
INSERT INTO ADVOGADO(primeiro_nome, ultimo_nome, email, senha, oab, uf) VALUES ('João', 'Souza', 'eusoujoao@gmail.com','$2a$12$zOxbc3KtPbKmHqEFMnWgfOVFdyMq5MreX7ZQM9snN7Rbv8hWfAya6', '88745', 'BA');
INSERT INTO ADVOGADO(primeiro_nome, ultimo_nome, email, senha, oab, uf) VALUES ('Maria', 'Carvalho', 'maria.carvalho@gmail.com','$2a$12$zOxbc3KtPbKmHqEFMnWgfOVFdyMq5MreX7ZQM9snN7Rbv8hWfAya6', '23555', 'BA');


INSERT INTO DILIGENCIA(processo, classe, tipo_de_diligencia, comentario, prioridade, data_da_diligencia, data_da_conclusao, advogado_id) VALUES ('8000455-25.2018.8.05.0001', 'Alimentos', 'Decisao', 'Requer deferimento da liminar', true, '2022-01-19', '2019-05-05', 1);
INSERT INTO DILIGENCIA(processo, classe, tipo_de_diligencia, comentario, prioridade, data_da_diligencia, data_da_conclusao, advogado_id) VALUES ('8000111-11.2022.8.05.0001', 'Divorcio', 'Sentenca', 'Comentário de teste', false, '2022-01-23', '2022-01-01', 1);
INSERT INTO DILIGENCIA(processo, classe, tipo_de_diligencia, comentario, prioridade, data_da_diligencia, data_da_conclusao, advogado_id) VALUES ('8002596-00.2020.8.05.0001', 'Busca e Apreensão', 'Despacho', 'Requer a citação do réu', false, '2022-01-19', '2020-05-05', 3);
INSERT INTO DILIGENCIA(processo, classe, tipo_de_diligencia, comentario, prioridade, data_da_diligencia, data_da_conclusao, advogado_id) VALUES ('8000778-05.2021.8.05.0001', 'Divorcio', 'Sentenca', 'Requer a sentença do processo com urgência parte idosa', true, '2022-01-19', '2019-05-05', 2);


