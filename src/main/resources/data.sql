INSERT INTO public.address(
	id, city, postal_code, street, street_number) VALUES
	(1001, 'Warszawa', '02-326', 'Al. Jerozolimskie', '157'),
	(1002, 'Kraków', '31-707', 'Powstańców Wielkopolskich', '13'),
	(1003, 'Wrocław', '50-086', 'Sucha', '15c'),
	(1004, 'Poznań', '60-246', 'Winklera', '1');

INSERT INTO public.branch(
	id, address_id) VALUES (1001, 1), (1002,2), (1003,3), (1004,4);

INSERT INTO public.employee(
	id, first_name, last_name, user_name, password, "position", is_admin , branch_id) VALUES
	(1001, 'Piotr', 'Nowak', 'admin', 'admin', 'administrator', TRUE, 1),
	(1002, 'Adam', 'Kowalski', 'adamk', 'qwerty', 'director', FALSE, 1),
	(1003, 'Anna', 'Jabłońska', 'anna85', 'jablko123', 'accountant', FALSE, 1),
	(1004, 'Justyna', 'Duda', 'justi', 'j2355', 'salesman', FALSE, 1),
	(1005, 'Jan', 'Miller', 'janmil', 'm88jan', 'salesman', FALSE, 1),
	(1006, 'Andrzej', 'Kowalczyk', 'kowal', 'ak47ak', 'manager', FALSE, 2),
	(1007, 'Krystyna', 'Lewandowska', 'kristi', 'mnbvc', 'salesman', FALSE, 2),
	(1008, 'Błażej', 'Gil', 'gilu87', 'bb8gil', 'salesman', FALSE, 2),
	(1009, 'Filip', 'Hajzer', 'proszek', 'doprania1', 'salesman', FALSE, 3),
	(10010, 'Cezary', 'Wałęsa', 'bolek', 'matolek11', 'salesman', FALSE, 3),
	(10011, 'Krystian', 'Kajetan', 'kriss', 'kaj79', 'salesman', FALSE, 3),
	(10012, 'Marcin', 'Marciniak', 'iceman', 'coder123', 'salesman', FALSE, 3);

INSERT INTO public.car(
	id, brand, model, production_year, specification, branch_id, base_price_per_day) VALUES
	(1001, 'Ford', 'Mondeo', '2017', 'Liftback 2.0 EcoBoost 240KM 177kW', 1, 60.00 ),
	(1002, 'Ford', 'Mondeo', '2017', 'Liftback 1.5 EcoBoost 165KM 121kW', 1, 55.00 ),
	(1003, 'Ford', 'Explorer', '2018', '2.3 EcoBoost 280KM 206kW', 1, 120.00 ),
	(1004, 'Audi', 'A3', '2017', '8V Hatchback 3d 2.0 TDI 150KM 110kW', 1, 60.00 ),
	(1005, 'Audi', 'A5', '2019', 'RS5 Sportback 2.9 TFSI 450KM 331kW', 1, 120.00 );