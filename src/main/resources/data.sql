INSERT INTO public.address(
	id, city, postal_code, street, street_number) VALUES
	(1001, 'Warszawa', '02-326', 'Al. Jerozolimskie', '157'),
	(1002, 'Kraków', '31-707', 'Powstańców Wielkopolskich', '13'),
	(1003, 'Wrocław', '50-086', 'Sucha', '15c'),
	(1004, 'Poznań', '60-246', 'Winklera', '1');

INSERT INTO public.branch(
	id, address_id) VALUES (1001, 1001), (1002,1002), (1003,1003), (1004,1004);

INSERT INTO public.employee(
	id, first_name, last_name, user_name, password, "position", is_admin , branch_id) VALUES
	(1001, 'Piotr', 'Nowak', 'admin', 'admin', 'administrator', TRUE, 1001),
	(1002, 'Adam', 'Kowalski', 'adamk', 'qwerty', 'director', FALSE, 1001),
	(1003, 'Anna', 'Jabłońska', 'anna85', 'jablko123', 'accountant', FALSE, 1001),
	(1004, 'Justyna', 'Duda', 'justi', 'j2355', 'salesman', FALSE, 1001),
	(1005, 'Jan', 'Miller', 'janmil', 'm88jan', 'salesman', FALSE, 1001),
	(1006, 'Andrzej', 'Kowalczyk', 'kowal', 'ak47ak', 'manager', FALSE, 1002),
	(1007, 'Krystyna', 'Lewandowska', 'kristi', 'mnbvc', 'salesman', FALSE, 1002),
	(1008, 'Błażej', 'Gil', 'gilu87', 'bb8gil', 'salesman', FALSE, 1002),
	(1009, 'Filip', 'Hajzer', 'proszek', 'doprania1', 'salesman', FALSE, 1003),
	(10010, 'Cezary', 'Wałęsa', 'bolek', 'matolek11', 'salesman', FALSE, 1003),
	(10011, 'Krystian', 'Kajetan', 'kriss', 'kaj79', 'salesman', FALSE, 1003),
	(10012, 'Marcin', 'Marciniak', 'iceman', 'coder123', 'salesman', FALSE, 1003);

INSERT INTO public.car(
	id, brand, model, production_year, specification, branch_id, base_price_per_day) VALUES
	(1001, 'Ford', 'Mondeo', '2017', 'Liftback 2.0 EcoBoost 240KM 177kW', 1001, 60.00 ),
	(1002, 'Ford', 'Mondeo', '2017', 'Liftback 1.5 EcoBoost 165KM 121kW', 1001, 55.00 ),
	(1003, 'Ford', 'Explorer', '2018', '2.3 EcoBoost 280KM 206kW', 1001, 120.00 ),
	(1004, 'Audi', 'A3', '2017', '8V Hatchback 3d 2.0 TDI 150KM 110kW', 1001, 60.00 ),
	(1005, 'Audi', 'A5', '2019', 'RS5 Sportback 2.9 TFSI 450KM 331kW', 1001, 120.00 );

INSERT INTO public.customer(
    id, email, first_name, last_name, password, user_name, address_id)
VALUES (1001, 'u1@gmail.com', 'Grzegorz', 'Fruwa', 'pass1', 'us1', 1001),
       (1002,'u2@gmail.com','Anrzej','Skorupa','pass2','endrju', 1002);

INSERT INTO public.reservation(
    id, cost, reservation_date, reservation_end, reservation_start, car_id, customer_id)
VALUES (1001, 500, '10-10-2020', '14-10-2020', '22-06-2020', 1001, 1001),
       (1002, 400, '09-10-2020', '11-10-2020', '10-08-2020', 1002, 1002),
       (1003, 300, '10-11-2020', '14-10-2020', '12-06-2020', 1001, 1002),
       (1004, 1200, '12-11-2020', '15-12-2020', '05-07-2020', 1003, 1001);


INSERT INTO public.damage(
    id, damage_penalty, description)
VALUES (1001, 0,'-'),
       (1002, 50, 'broken mirror'),
       (1003, 100, 'accident, doors broken'),
       (1004, 0, '-');

INSERT INTO public.rental(
    id, overdue_penalty, return_date, was_overdue, damage_id, reservation_id)
VALUES (1001, 0, '14-10-2020', 'False', 1001, 1001),
       (1002, 100, '09-10-2020', 'True', 1002, 1002),
       (1003, 70, '15-10-2020', 'True', 1003, 1003),
       (1004, 0, '14-12-2020', 'False', 1004, 1004);