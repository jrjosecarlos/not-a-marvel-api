INSERT INTO nama."character"(id_character, name, description, modified) VALUES
('f100b1df-07c7-4f2d-a604-c322c36933d6', 'Renato', 'Um heroi forte, veloz, ágil e simplório', '2000-05-07T16:52:13-05:00'),
('5f442d4b-f0eb-4e49-aaeb-5526f8dd7ced', 'Scott', 'Vivendo uma infância solitária e sem os pais, Scott conversava apenas com seu amigo imaginário Gilbert. Porém, após crescer, ficou a dúvida: quem efetivamente está no controle? Scott ou Gilbert?', current_timestamp()),
('740bc432-8a58-4daf-9194-c98da0df6781', 'Nicholas', 'Oriundo da Philadelphia, Nick não consegue lidar bem com outras pessoas. Seu objetivo é sempre ganhar, nunca perder. Sua vida mudou quando, numa situação que parecia apenas outra disputa qualquer, acabou acidentalmente tirando a vida de seu melhor amigo.', current_timestamp()),
('a9727005-1b1d-4325-aba8-7954f4151426', 'Clark', 'Um vilão destemido, cujo objetivo é apenas um: destruir o mundo', current_timestamp()),
('6761af20-2ee6-421c-8923-379e45200d8e', 'Gilbert', 'Surgindo apenas como um "amigo imaginário" de Scott, tomou forma própria e se tornou uma entidade independente. Ou nem tão independente assim?', current_timestamp());

INSERT INTO nama.creator(id_creator, first_name, middle_name, last_name, suffix, modified) values
('9582c309-6af3-48f5-9a00-346212cca788', 'John', null, 'Doe', null, current_timestamp()),
('3602c2c4-d5b2-4a5c-bfff-b042a3ed104e', 'Mary', 'Sally', 'Star', null, current_timestamp()),
('e6655ef0-a8ff-46d7-861b-8cdb9934a7bb', 'Paulo', null, 'Silva', 'Jr', current_timestamp()),
('ee4128b0-a9dd-4a67-92ce-669a4071f844', 'Lee', 'Song', 'Li', 'III', current_timestamp()),
('b9201cd7-3dbe-4802-be29-e8b66c143d55', 'Manuel', null, 'Cassidy', null, current_timestamp()),
('3f55d4c6-ff98-4737-8184-159381542aea', 'Georgiana', 'Cooper', 'Harmon', null, current_timestamp()),
('2375d704-09b3-4260-a9e3-872ac7722c4e', 'Elaine', null, 'Martin', null, current_timestamp()),
('0ba21083-6061-4990-ab57-068a8b2daa1d', 'Taio', 'Escobar', 'Dawson', 'II', current_timestamp()),
('74da9a10-fa7d-4043-9401-fa35c4bd7697', 'Natalia', null, 'Doyle', null, current_timestamp()),
('8f08ee4f-f308-441d-a691-1c73e35c9479', 'Rickie', null, 'Noel', 'Jr', current_timestamp()),
('623da505-c5d0-422d-9ee1-f7f384813dae', 'Nina', 'Pearson', 'Sparks', null, current_timestamp());

INSERT INTO nama.story(id_story, title, "type", description, modified) VALUES
('a55e879d-fb24-424c-bff0-3d1f2657aa55', 'O Mundo de Renato (2012) #100', 'cover', 'Nessa edição histórica, Renato enfrenta novamente seu eterno inimigo, Clark.', current_timestamp()),
('cd2aa155-b116-4705-83c3-4899caa0062c', 'O Mundo de Renato (2012) #100 interior', 'interior', 'Num raro momento de descanso, Renato lembra de sua adolescência, quando as coisas eram mais simples.', current_timestamp()),
('d3e46151-13fc-422d-a8e9-dce7b0631c68', 'Scott (1992) #87', 'cover', 'Após o desaparecimento de Gilbert, Scott não sabe o que fazer. Será que viver ainda vale a pena?', current_timestamp()),
('6f88c1ff-07e2-45fe-ac9d-00744dc2d1d1', 'Scott (1992) #87 interior', 'interior', 'Continuando a investigação das origens de Gilbert, veremos finalmente quando ele surgiu pela primeira vez na vida de Scott.', current_timestamp()),
('641c0288-6aee-4d35-bffb-34f9f3b9686a', 'Caso Philadelphia-GD347 (2001)', 'text', 'Uma visão do caso mais discutido dos últimos tempos na Philadelphia, na visão das pessoas que estiveram lá.', current_timestamp());

INSERT INTO nama.series (id_series, title, description, start_year, end_year, rating, modified, previous_series_id) VALUES
('efa4acd4-0a73-4849-b79e-356830fedf71', 'O Mundo de Renato (2012)', 'Na escola, Renato era um garoto simples, que sempre era humilhado por seus colegas. Numa aula de Química, um acidente mudou totalmente a vida do rapaz.', 2012, 2018, '12 and up', current_timestamp(), null),
('5cb44616-871f-4446-a1aa-591834c2a6d5', 'Scott (1992)', 'Scott dormia sozinho. Em seus sonhos, uma voz ao longe falava com ele: "Você terá um amigo, e não ficará mais sozinho". Até o dia em que ele acordou, e uma nova voz passou a acompanhá-lo. Mas agora o problema era o oposto: Scott não conseguia mais ficar sozinho.', 1990, 2005, 'over 18', current_timestamp(), null),
('8b57a5db-0448-4d22-a5c7-7dd83d7de8b4', 'Caso Philadelphia-GD347 (2001)', null, 2001, 2001, '16 and up', current_timestamp(), null),
('4ad01caa-eea2-4359-9d21-7811b10423ff', 'Caso Philadelphia-GD348 (2003)', null, 2003, 2003, '16 and up', current_timestamp(), '8b57a5db-0448-4d22-a5c7-7dd83d7de8b4');

INSERT INTO nama.comic (id_comic, series_id, original_comic_id, digital_id, title, issue_number, description, isbn, upc, diamond_code, ean, issn, format, page_count, variant_description, modified) VALUES
('fc522501-11eb-4907-b201-6dd5659ac706', 'efa4acd4-0a73-4849-b79e-356830fedf71', null, null, 'O Mundo de Renato (2012) #100', 100, 'Edição histórica de número 100 do Mundo de Renato, onde ele irá encontrar velhos inimigos e olhar um pouco para seu próprio passado', null, null, null, null, null, 'Comic', 28, null, current_timestamp()),
('c19ad9bf-88e8-4d71-84e2-e6c9b54290c8', '5cb44616-871f-4446-a1aa-591834c2a6d5', null, 1910567, 'Scott (1992) #87', 87, 'Como Scott irá se comportar após o desaparecimento de Gilbert?', null, '1-234-5678', null, null, null, 'Comic', 34, null, current_timestamp()),
('126ff9d1-9f41-4f6d-9fc4-9fbe45106bbb', '8b57a5db-0448-4d22-a5c7-7dd83d7de8b4', null, 953472, 'Caso Philadelphia-GD347 (2001)', 1, 'Uma visão do caso mais discutido dos últimos tempos na Philadelphia, na visão das pessoas que estiveram lá.', '978-3-24-587954-0', null, 'JAN548720', null, null, 'Hardback', 109, null, current_timestamp()),
('a3bbb1f2-0493-4566-88c8-176852954664', '8b57a5db-0448-4d22-a5c7-7dd83d7de8b4', '126ff9d1-9f41-4f6d-9fc4-9fbe45106bbb', 953473, 'Caso Philadelphia-GD347 (2001) (Variant)', 1, 'Uma visão do caso mais discutido dos últimos tempos na Philadelphia, na visão das pessoas que estiveram lá.', '978-3-24-587978-0', null, 'JAN548721', null, null, 'Hardback', 109, 'Alternate Cover', current_timestamp()),
('6bcbb850-2898-4fe3-8a76-c981d26f7d9a', 'efa4acd4-0a73-4849-b79e-356830fedf71', null, null, 'O Mundo de Renato (2012) #117', 117, 'Durante o Expurgo, Renato tenta fazer o que pode para evitar perder seus amigos.', null, '5-864-44127-8', null, null, null, 'Comic', 32, null, current_timestamp()),
('c8729ff0-fb7c-4df1-9b36-94b3c9bbd34f', '5cb44616-871f-4446-a1aa-591834c2a6d5', null, null, 'Scott (1992) #88', 88, 'Descrição Scott (1992) #88', null, '1-234-5679', null, null, null, 'Comic', 34, null, current_timestamp()),
('3673d7f4-c720-4a6c-b3bb-99625b5ee266', '5cb44616-871f-4446-a1aa-591834c2a6d5', null, null, 'Scott (1992) #89', 89, 'Descrição Scott (1992) #89', null, '1-234-5680', null, null, null, 'Comic', 34, null, current_timestamp()),
('93a934da-40a6-4adb-8e70-111711cd8450', '5cb44616-871f-4446-a1aa-591834c2a6d5', null, null, 'Scott (1992) 3º trimestre', 0, 'Coleção contendo as edições de Scott (1992) do 3º trimestre (#87, #88 e #89)', '987-3-55876-4', null, null, null, null, 'Hardback', 102, null, current_timestamp());

INSERT INTO nama.event (id_event, title, description, start_date, end_date, modified, previous_event_id) VALUES
('08b2ad5c-ccec-4af1-a2c8-ad91d0814a93', 'Expurgo', 'E quando as entidades superiores entendem que o universo não está como desejavam? A solução é simples: expurgo do universo atual.', '2012-05-06 00:00', '2012-12-10 00:00', current_timestamp(), null),
('56f047a5-b82d-4c33-8927-c14e001707f6', 'Um novo mundo', 'Partindo das consequências do Expurgo, os sobreviventes tentam encontrar novos objetivos, já que o lar que conheciam não existe mais.', '2015-01-02 00:00', '2017-04-28 00:00', current_timestamp(), '08b2ad5c-ccec-4af1-a2c8-ad91d0814a93');

INSERT INTO nama.comic_descriptive_text(id_comic_descriptive_text, comic_id, "type", language, "text", modified) VALUES
('c5bdfba6-b24d-428d-8ac5-0dc50325b19d', '126ff9d1-9f41-4f6d-9fc4-9fbe45106bbb', 'preview text', 'pt-BR', 'Uma visão do caso mais discutido dos últimos tempos na Philadelphia, na visão das pessoas que estiveram lá.', current_timestamp()),
('a8e1dbcd-790d-4aa9-8588-539dc365b969', '126ff9d1-9f41-4f6d-9fc4-9fbe45106bbb', '15 year anniversary', 'en-US', 'Go (back) to Philadelphia and (re)discover this modern classic!', current_timestamp()),
('58df734e-c90e-44a7-89ef-4211440af730', 'c19ad9bf-88e8-4d71-84e2-e6c9b54290c8', 'preview text', 'en-US', 'How will Scott behave after Gilbert''s disappearence?', current_timestamp());

INSERT INTO nama.comic_date (id_comic_date, comic_id, "type", "date", modified) VALUES
('1a661081-ddc9-4ca9-862c-c1f5a94ec882', 'fc522501-11eb-4907-b201-6dd5659ac706', 'release date', '2014-05-17T00:00:00-04:00', current_timestamp()),
('be1562d1-552c-493a-bafa-e1272acf9d3d', 'fc522501-11eb-4907-b201-6dd5659ac706', 'digital release date', '2018-06-21T12:00:00-05:00', current_timestamp()),
('8c002edd-fc89-452b-9f1a-bbf962b02449', 'c19ad9bf-88e8-4d71-84e2-e6c9b54290c8', 'release date', '1993-09-18T06:00:00-04:00', current_timestamp());

INSERT INTO nama.comic_price (id_comic_price, comic_id, "type", price, modified) VALUES
('efc9684e-c464-4309-bbb9-b0bf6876a3d8', 'fc522501-11eb-4907-b201-6dd5659ac706', 'printPrice', 5.99, current_timestamp()),
('ed5faf9e-4548-418c-aeda-31d2f9acb560', 'c19ad9bf-88e8-4d71-84e2-e6c9b54290c8', 'printPrice', 3.99, current_timestamp()),
('83e7cf0b-15c4-4cc5-b9bb-0a697c9e19ea', 'c19ad9bf-88e8-4d71-84e2-e6c9b54290c8', 'digitalPrice', 2.99, current_timestamp()),
('8db16d7d-2758-435a-8ff9-70b0c1b38782', '126ff9d1-9f41-4f6d-9fc4-9fbe45106bbb', 'printPrice', 19.99, current_timestamp()),
('270ebf4c-8a60-4f7d-b450-9c11f2a8b73c', '126ff9d1-9f41-4f6d-9fc4-9fbe45106bbb', 'digitalPrice', 14.99, current_timestamp());

INSERT INTO nama.story_creator (story_id, creator_id, role) VALUES
('a55e879d-fb24-424c-bff0-3d1f2657aa55', 'ee4128b0-a9dd-4a67-92ce-669a4071f844', 'writer'),
('a55e879d-fb24-424c-bff0-3d1f2657aa55', '8f08ee4f-f308-441d-a691-1c73e35c9479', 'inker (cover)'),
('a55e879d-fb24-424c-bff0-3d1f2657aa55', 'b9201cd7-3dbe-4802-be29-e8b66c143d55', 'texter'),
('641c0288-6aee-4d35-bffb-34f9f3b9686a', 'e6655ef0-a8ff-46d7-861b-8cdb9934a7bb', 'writer'),
('cd2aa155-b116-4705-83c3-4899caa0062c', '0ba21083-6061-4990-ab57-068a8b2daa1d', 'writer'),
('cd2aa155-b116-4705-83c3-4899caa0062c', '8f08ee4f-f308-441d-a691-1c73e35c9479', 'inker'),
('d3e46151-13fc-422d-a8e9-dce7b0631c68', '623da505-c5d0-422d-9ee1-f7f384813dae', 'writer'),
('d3e46151-13fc-422d-a8e9-dce7b0631c68', '9582c309-6af3-48f5-9a00-346212cca788', 'inker (cover)'),
('d3e46151-13fc-422d-a8e9-dce7b0631c68', '3f55d4c6-ff98-4737-8184-159381542aea', 'inker'),
('6f88c1ff-07e2-45fe-ac9d-00744dc2d1d1', '2375d704-09b3-4260-a9e3-872ac7722c4e', 'texter');

INSERT INTO nama.story_character (story_id, character_id) VALUES
('a55e879d-fb24-424c-bff0-3d1f2657aa55', 'f100b1df-07c7-4f2d-a604-c322c36933d6'),
('a55e879d-fb24-424c-bff0-3d1f2657aa55', 'a9727005-1b1d-4325-aba8-7954f4151426'),
('cd2aa155-b116-4705-83c3-4899caa0062c', 'f100b1df-07c7-4f2d-a604-c322c36933d6'),
('d3e46151-13fc-422d-a8e9-dce7b0631c68', '5f442d4b-f0eb-4e49-aaeb-5526f8dd7ced'),
('6f88c1ff-07e2-45fe-ac9d-00744dc2d1d1', '6761af20-2ee6-421c-8923-379e45200d8e'),
('6f88c1ff-07e2-45fe-ac9d-00744dc2d1d1', '5f442d4b-f0eb-4e49-aaeb-5526f8dd7ced'),
('641c0288-6aee-4d35-bffb-34f9f3b9686a', '740bc432-8a58-4daf-9194-c98da0df6781');

INSERT INTO nama.comic_story (comic_id, story_id) VALUES
('fc522501-11eb-4907-b201-6dd5659ac706', 'a55e879d-fb24-424c-bff0-3d1f2657aa55'),
('fc522501-11eb-4907-b201-6dd5659ac706', 'cd2aa155-b116-4705-83c3-4899caa0062c'),
('c19ad9bf-88e8-4d71-84e2-e6c9b54290c8', 'd3e46151-13fc-422d-a8e9-dce7b0631c68'),
('c19ad9bf-88e8-4d71-84e2-e6c9b54290c8', '6f88c1ff-07e2-45fe-ac9d-00744dc2d1d1'),
('126ff9d1-9f41-4f6d-9fc4-9fbe45106bbb', '641c0288-6aee-4d35-bffb-34f9f3b9686a');

INSERT INTO nama.event_comic (event_id, comic_id) VALUES
('08b2ad5c-ccec-4af1-a2c8-ad91d0814a93', '6bcbb850-2898-4fe3-8a76-c981d26f7d9a');

INSERT INTO nama.comic_collection(collection_comic_id, collected_comic_id) VALUES
('93a934da-40a6-4adb-8e70-111711cd8450', 'c19ad9bf-88e8-4d71-84e2-e6c9b54290c8'),
('93a934da-40a6-4adb-8e70-111711cd8450', 'c8729ff0-fb7c-4df1-9b36-94b3c9bbd34f'),
('93a934da-40a6-4adb-8e70-111711cd8450', '3673d7f4-c720-4a6c-b3bb-99625b5ee266');
