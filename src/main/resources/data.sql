INSERT INTO sogn (kode, navn, dato_for_nedlukning, smittetryk) VALUES
(7975, 'Givskud', TO_DATE('03/06/2021', 'DD/MM/YYYY'), 2.1),
(8364, 'Budolfi', TO_DATE('30/05/2021', 'DD/MM/YYYY'), 1.8),
(8366, 'Vor Frelsers', TO_DATE('24/05/2021', 'DD/MM/YYYY'), 1.5),
(8368, 'Vor Frue', TO_DATE('04/06/2021', 'DD/MM/YYYY'), 1.1),
(9310, 'Høsterkøb', TO_DATE('29/05/2021', 'DD/MM/YYYY'), 0.9);

INSERT INTO kommune (kode, navn, sogn_id) VALUES
(630, 'Vejle', 1),
(851, 'Aalborg', 2),
(230, 'Rudersdal', 3),
(522, 'København', 4),
(133, 'Randers', 5);

UPDATE sogn SET kommune_id=1 where id=1;
UPDATE sogn SET kommune_id=2 where id=2;
UPDATE sogn SET kommune_id=3 where id=3;
UPDATE sogn SET kommune_id=4 where id=4;
UPDATE sogn SET kommune_id=5 where id=5;