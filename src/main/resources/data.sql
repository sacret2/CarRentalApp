INSERT INTO public.address(
	id, city, postal_code, street, street_number) VALUES
	(1001, 'Warszawa', '02-326', 'Al. Jerozolimskie', '157'),
	(1002, 'Kraków', '31-707', 'Powstańców Wielkopolskich', '13'),
	(1003, 'Wrocław', '50-086', 'Sucha', '15c'),
	(1004, 'Poznań', '60-246', 'Winklera', '1');

INSERT INTO public.branch(
    id, address_id) VALUES (1001, 1001), (1002,1002), (1003,1003), (1004,1004);

INSERT INTO public.car(
    id, brand, model, production_year, specification, branch_id, base_price_per_day) VALUES
(1001, 'Ford', 'Mondeo', '2017', 'Liftback 2.0 EcoBoost 240KM 177kW', 1001, 60.00 ),
(1002, 'Ford', 'Mondeo', '2017', 'Liftback 1.5 EcoBoost 165KM 121kW', 1001, 55.00 ),
(1003, 'Ford', 'Explorer', '2018', '2.3 EcoBoost 280KM 206kW', 1001, 120.00 ),
(1004, 'Audi', 'A3', '2017', '8V Hatchback 3d 2.0 TDI 150KM 110kW', 1001, 60.00 ),
(1005, 'Audi', 'A5', '2019', 'RS5 Sportback 2.9 TFSI 450KM 331kW', 1001, 120.00 );

INSERT INTO public.employee(
	id, first_name, last_name, user_name, password, "position", is_admin , branch_id) VALUES
	(1001, 'Piotr', 'Nowak', 'admin', 'admin', 'administrator', TRUE, 1001),
	(1002, 'Adam', 'Kowalski', 'e', 'e', 'director', FALSE, 1001),
	(1003, 'Anna', 'Jabłońska', 'anna85', 'jablko123', 'accountant', FALSE, 1001),
	(1004, 'Justyna', 'Duda', 'justi', 'j2355', 'salesman', FALSE, 1001),
	(1005, 'Jan', 'Miller', 'janmil', 'm88jan', 'salesman', FALSE, 1001),
	(1006, 'Andrzej', 'Kowalczyk', 'kowal', 'ak47ak', 'manager', FALSE, 1002),
	(1007, 'Krystyna', 'Lewandowska', 'kristi', 'mnbvc', 'salesman', FALSE, 1002),
	(1008, 'Błażej', 'Gil', 'gilu87', 'bb8gil', 'salesman', FALSE, 1002),
	(1009, 'Filip', 'Hajzer', 'proszek', 'doprania1', 'salesman', FALSE, 1003),
	(10010, 'Cezary', 'Wałęsa', 'bolek', 'matolek11', 'salesman', FALSE, 1003),
	(10011, 'Krystian', 'Kajetan', 'kriss', 'kaj79', 'salesman', FALSE, 1004),
	(10012, 'Marcin', 'Marciniak', 'iceman', 'coder123', 'salesman', FALSE, 1004);

INSERT INTO public.customer(
    id, email, first_name, last_name, password, user_name, address_id)
VALUES (1001, 'u1@gmail.com', 'Grzegorz', 'Fruwa', 'a', 'a', 1001),
       (1002,'u2@gmail.com','Andrzej','Skorupa','pass2','endrju', 1002);

INSERT INTO public.reservation(
    id, cost, reservation_start, reservation_end, reservation_date, car_id, customer_id) VALUES
    (1001, 500, DATE'2020-10-10', DATE'2020-10-14', DATE'2020-06-22', 1001, 1001),
       (1002, 400, DATE'2020-10-09', DATE'2020-10-13', DATE'2020-08-10', 1002, 1002),
       (1003, 300, DATE'2020-11-10', DATE'2020-11-18', DATE'2020-06-12', 1001, 1002),
       (1004, 1200, DATE'2020-12-12', DATE'2020-12-21', DATE'2020-07-05', 1003, 1001);

INSERT INTO public.damage(
    id, damage_penalty, description)
VALUES (1001, 0,'-'),
       (1002, 50, 'broken mirror'),
       (1003, 100, 'accident, doors broken'),
       (1004, 0, '-');

INSERT INTO public.rental(
    id, overdue_penalty, return_date, was_overdue, damage_id, reservation_id)
VALUES (1001, 0, DATE'2020-10-14', 'False', 1001, 1001),
       (1002, 100, DATE '2020-10-09', 'True', 1002, 1002),
       (1003, 70, DATE'2020-10-15', 'True', 1003, 1003),
       (1004, 0, DATE'2020-12-14', 'False', 1004, 1004);
