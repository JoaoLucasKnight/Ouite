-- Inserindo dados na tabela Space
INSERT INTO Space (nome, descricao, caminho, id_space_pai)
VALUES
    ('Quarto', 'Melhro lugar do mundo', NULL, NULL),   -- Espaço principal (Quarto)
    ('Banheiro', 'Não preciso dizer nada ', NULL, 1);  -- Subespaço (Banheiro)

-- Inserindo dados na tabela Box
INSERT INTO Box (nome, descricao, caminho, id_space, id_box_pai)
VALUES
    ('Armario', 'Armario Principal', NULL, 1, NULL),  -- Box (Armario)
    ('Porta da Direita', 'Roupas e acessorios', NULL, 1, 1),             -- Subbox  dentro do Armario
    ('Porta Central', 'Roupas de cama e outros', NULL, 1, 1),            -- Subbox  dentro do Armario
    ('Porta Esqueda', 'Acessoriso de Traitlho e outros', NULL, 1, 1);     -- Subbox  dentro do Armario

-- Inserindo dados na tabela Artifact
INSERT INTO Artifact (nome, descricao, caminho, id_space, id_box)
VALUES
    ('Cadeira', 'Minha cadeira de leitura', NULL, 1, NULL),          -- Artefato (Cadeira) no espaço principal (Quarto)
    ('Caixa do Teclado', 'uma caixa velha de teclado', NULL, 1, 2);  -- Artefato (caixas) na Porta da direita