insert into items (name)
values
       ('Pão'), ('Café'), ('Bolo de Chocolate'), ('Bolo de Laranja'),
       ('Suco de Laranja'), ('Refrigerante'), ('Queijo'), ('Presunto'),
       ('Carolina'), ('Vanderléia'), ('Donut'), ('Torrada');

insert into COLLABORATORS (FULL_NAME, CPF)
values
('Lucas da Silva', '11122233344'), ('Jorge da Silva Lima', '22233344455'),
('Igor Henrique Bonfim', '99966655544'), ('Henrique Oliveira', '77788855522'),
('João de Paula Silveira', '66677799955'), ('Fernando Henrique Araújo', '33377766699');

insert into collaborator_items ( collaborator_id , item_id )
values
(1, 1), (1, 3), (3, 2),
(4, 5), (4, 12), (4, 11),
(2, 7), (2, 8);