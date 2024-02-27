-- Criação da tabela Space
CREATE TABLE Space (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL,
                       descricao VARCHAR(255) NOT NULL,
                       caminho VARCHAR(255),
                       space_id INT,
                       box_id INT,
                       algo_id INT,
                       FOREIGN KEY (space_id) REFERENCES Space(id),
                       FOREIGN KEY (box_id) REFERENCES Box(id),
                       FOREIGN KEY (algo_id) REFERENCES Algo(id)
);

-- Inserção de dados na tabela Space
-- INSERT INTO Space (nome, descricao, caminho, space_id, box_id, algo_id)
-- VALUES
--     ('Espaço 1', 'Descrição do espaço 1', '/caminho/espaco1', NULL, NULL, NULL),
--     ('Espaço 2', 'Descrição do espaço 2', '/caminho/espaco2', NULL, NULL, NULL);
