-- Criação da tabela Algo
CREATE TABLE Algo (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      nome VARCHAR(255) NOT NULL,
                      descricao VARCHAR(255) NOT NULL,
                      caminho VARCHAR(255),
                      algo_id INT,
                      FOREIGN KEY (algo_id) REFERENCES Algo(id)
);

-- Inserção de dados na tabela Algo
-- INSERT INTO Algo (nome, descricao, caminho, algo_id)
-- VALUES
--     ('Algo 1', 'Descrição do algo 1', '/caminho/algo1', NULL),
--     ('Algo 2', 'Descrição do algo 2', '/caminho/algo2', NULL);
