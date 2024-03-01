-- Tabela Space
CREATE TABLE Space (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nome VARCHAR(255) NOT NULL,
                       descricao TEXT,
                       caminho VARCHAR(255),
                       id_space_pai BIGINT,
                       FOREIGN KEY (id_space_pai) REFERENCES Space(id)
);

-- Tabela Box
CREATE TABLE Box (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     nome VARCHAR(255) NOT NULL,
                     descricao TEXT,
                     caminho VARCHAR(255),
                     id_space BIGINT NOT NULL,
                     id_box_pai BIGINT,
                     FOREIGN KEY (id_space) REFERENCES Space(id),
                     FOREIGN KEY (id_box_pai) REFERENCES Box(id)
);

-- Tabela Artifact
CREATE TABLE Artifact (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          descricao TEXT,
                          caminho VARCHAR(255),
                          id_space BIGINT NOT NULL,
                          id_box BIGINT,
                          FOREIGN KEY (id_space) REFERENCES Space(id),
                          FOREIGN KEY (id_box) REFERENCES Box(id)
);
