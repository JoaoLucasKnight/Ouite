-- Criação da tabela Box
CREATE TABLE Box (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     nome VARCHAR(255) NOT NULL,
                     descricao VARCHAR(255) NOT NULL,
                     caminho VARCHAR(255),
                     box_id INT,
                     algo_id INT,
                     FOREIGN KEY (box_id) REFERENCES Box(id),
                     FOREIGN KEY (algo_id) REFERENCES Algo(id)
);

-- Inserção de dados na tabela Box
-- INSERT INTO Box (nome, descricao, caminho, box_id, algo_id)
-- VALUES
--     ('Box 1', 'Descrição da box 1', '/caminho/box1', NULL, NULL),
--     ('Box 2', 'Descrição da box 2', '/caminho/box2', NULL, NULL);
