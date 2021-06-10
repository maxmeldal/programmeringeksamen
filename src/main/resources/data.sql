INSERT INTO sogn (kode, navn, dato_for_nedlukning, smittetryk) VALUES
(7975, 'Givskud', TO_DATE('03/06/2021', 'DD/MM/YYYY'), 2.1),
(8364, 'Budolfi', TO_DATE('30/05/2021', 'DD/MM/YYYY'), 1.8),
(8366, 'Vor Frelsers', TO_DATE('24/05/2021', 'DD/MM/YYYY'), 1.5),
(8368, 'Vor Frue', TO_DATE('04/06/2021', 'DD/MM/YYYY'), 1.1),
(9310, 'Høsterkøb', TO_DATE('29/05/2021', 'DD/MM/YYYY'), 0.9);

INSERT INTO kommune (kode, navn, sogn_kode) VALUES
(630, 'Vejle', 7975),
(851, 'Aalborg', 8364),
(230, 'Rudersdal', 8366),
(522, 'København', 8368),
(133, 'Randers', 9310);

UPDATE sogn SET kommune_kode=630 where kode=7975;
UPDATE sogn SET kommune_kode=851 where kode=8364;
UPDATE sogn SET kommune_kode=230 where kode=8366;
UPDATE sogn SET kommune_kode=522 where kode=8368;
UPDATE sogn SET kommune_kode=133 where kode=9310;