INSERT INTO area (ar_id, ar_name) VALUES (1, 'A1');
INSERT INTO area (ar_id, ar_name) VALUES (2, 'A2');
INSERT INTO area (ar_id, ar_name) VALUES (3, 'A3');

INSERT INTO street (st_id, st_name, st_area_id) VALUES (1, 'Czarnowiejska', 1);
INSERT INTO street (st_id, st_name, st_area_id) VALUES (2, 'Zarzecze', 2);
INSERT INTO street (st_id, st_name, st_area_id) VALUES (3, 'Przybyszewskiego', 3);

INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (1, 1);
INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (2, 1);
INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (3, 2);
INSERT INTO parking_meter (pm_id, pm_street_id) VALUES (4, 3);

INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (1, FALSE, 1);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (2, FALSE, 1);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (3, FALSE, 1);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (4, FALSE, 2);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (5, FALSE, 2);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (6, FALSE, 2);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (7, FALSE, 3);
INSERT INTO parking_place (pp_id, pp_occupied, pp_street_id) VALUES (8, FALSE, 3);

INSERT INTO app_user (us_id, us_password, us_username, us_area_id, us_role) VALUES (1, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'user1', 1, 'ADMIN');
INSERT INTO app_user (us_id, us_password, us_username, us_area_id, us_role) VALUES (2, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'user2', 2, 'ADMIN');
INSERT INTO app_user (us_id, us_password, us_username, us_area_id, us_role) VALUES (3, 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'user3', 3, 'EMPLOYEE');