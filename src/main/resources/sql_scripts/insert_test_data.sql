INSERT INTO zoo.animal (id, kind, name, age) VALUES
(1, 'Ursus arctos', 'Masha', 12),
(2, 'Aptenodytes patagonicus', 'Finn', 2),
(3, 'Aldabrachelys gigantea', 'Tortilla', 120);

INSERT INTO zoo.disease (id, name) VALUES
(1, 'pyelonephritis'),
(2, 'helminths');

INSERT INTO zoo.animal_disease (animal_id, disease_id) VALUES
(1, 1),
(3, 2);