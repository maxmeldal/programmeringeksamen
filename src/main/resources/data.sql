INSERT INTO kommune (kode, navn) VALUES
(630, 'Vejle'),
(851, 'Aalborg'),
(230, 'Rudersdal'),
(820, 'Vesthimmerlands'),
(760, 'Rinkøbing-Skjern'),
(376, 'Guldborgsund');

INSERT INTO sogn (kode, navn, kommune_id, dato_for_nedlukning, positiv_procent) VALUES
(7975, 'Givskud', 1, TO_DATE('03/06/2021', 'DD/MM/YYYY'), 3.66),
(8364, 'Budolfi', 2, TO_DATE('30/05/2021', 'DD/MM/YYYY'), 3.11),
(8366, 'Vor Frelsers', 2, TO_DATE('24/05/2021', 'DD/MM/YYYY'), 3.37),
(8368, 'Vor Frue', 2, TO_DATE('04/06/2021', 'DD/MM/YYYY'), 2.34),
(9310, 'Høsterkøb', 3, TO_DATE('29/05/2021', 'DD/MM/YYYY'), 2.81),
(8284, 'Fovlum', 4, TO_DATE('13/04/2021', 'DD/MM/YYYY'), 12.24),
(8778, 'Faster', 5, TO_DATE('12/05/2021', 'DD/MM/YYYY'), 6.16),
(7985, 'Lindeballe', 1, TO_DATE('29/03/2021', 'DD/MM/YYYY'), 8.14),
(7593, 'Vigsnøs', 6, TO_DATE('13/01/2021', 'DD/MM/YYYY'), 11.76),
(7978, 'Vester', 1, TO_DATE('29/03/2021', 'DD/MM/YYYY'), 10.87);