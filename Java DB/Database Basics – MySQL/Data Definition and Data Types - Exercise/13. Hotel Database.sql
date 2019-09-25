CREATE TABLE employees(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
title VARCHAR(50),
notes TEXT
);

CREATE TABLE customers(
account_number INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
phone_number INT,
emergency_name VARCHAR(50),
emergency_number INT,
notes TEXT
);

CREATE TABLE room_status(
room_status VARCHAR(50) PRIMARY KEY NOT NULL,
notes TEXT
);

CREATE TABLE room_types(
room_type VARCHAR(50) PRIMARY KEY NOT NULL,
notes TEXT
);

CREATE TABLE bed_types(
bed_type VARCHAR(50) PRIMARY KEY NOT NULL,
notes TEXT
);

CREATE TABLE rooms(
room_number INT PRIMARY KEY NOT NULL,
room_type VARCHAR(50),
bed_type VARCHAR(50),
rate DECIMAL(10,2),
room_status VARCHAR(50),
notes TEXT
);

CREATE TABLE payments(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
employee_id INT NOT NULL,
payment_date DATE,
account_number INT,
first_date_occupied DATE,
last_date_occupied DATE,
total_days INT,
amount_charged DECIMAL(10,2),
tax_rate DECIMAL(10,2),
tax_amount DECIMAL(10,2),
payment_total DECIMAL(10,2) NOT NULL,
notes TEXT
);

CREATE TABLE occupancies(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
employee_id INT NOT NULL,
date_occupied DATE,
account_number INT,
room_number INT,
rate_applied DECIMAL(10,2),
phone_charge DECIMAL(10,2),
notes TEXT
);

INSERT INTO employees(first_name, last_name, title, notes)
VALUES('pesho', 'pesho', 'chistach', 'pechen'),
('pesho', 'pesho', 'chistach', 'pechen'),
('pesho', 'pesho', 'chistach', 'pechen');

INSERT INTO customers(first_name, last_name, phone_number, emergency_name, emergency_number, notes)
VALUES('ivan', 'ivan', 1999, 'pes3ho', 512123, 'pechen'),
('ivan', 'ivan', 1991239, 'pesh2o', 513323, 'pechen'),
('ivan', 'ivan', 1912399, 'pesh1o', 5123313, 'pechen');

INSERT INTO room_status(room_status, notes)
VALUES('dobra', 'ok'),
('dobraa', 'ok'),
('dobraaa', 'ok');

INSERT INTO room_types(room_type, notes)
VALUES('doqbra', 'ok'),
('dobraq', 'ok'),
('dobrqa', 'ok');

INSERT INTO bed_types(bed_type, notes)
VALUES('dobqweqwera', 'ok'),
('dobrqwea', 'ok'),
('dobqweqwqweera', 'ok');

INSERT INTO rooms(room_number, room_type, bed_type, rate, room_status, notes)
VALUES(1, 'dobrqwe', 'dvoino', 8.12, 'ready', 'za s boqn ;)'),
(2, 'dobreeee', 'dvoino', 8.11, 'ready', 'za s boqn ;)'),
(3, 'dobreqe', 'dvoino', 8.9, 'ready', 'za s boqn ;)');

INSERT INTO payments(employee_id, payment_date, account_number, first_date_occupied, last_date_occupied, total_days, amount_charged, tax_rate, tax_amount, payment_total, notes)
VALUES(1213, '1999-11-11', 123, '1999-11-11', NULL, NULL, 1919.12, 20.1, 400.12, 2300.12, 'super brat'),
(1213, '1999-11-11', 123, '1999-11-11', NULL, NULL, 1919.12, 20.1, 400.12, 2300.12, 'super brat'),
(1213, '1999-11-11', 123, '1999-11-11', NULL, NULL, 1919.12, 20.1, 400.12, 2300.12, 'super brat');

INSERT INTO occupancies(employee_id, date_occupied, account_number, room_number, rate_applied, phone_charge, notes)
VALUES(123, '1999-11-11', 1231, 1231, 12.12, 12.12, 'stiga'),
(123, '1999-11-11', 12311, 12311, 12.12, 12.12, 'stiga'),
(123, '1999-11-11', 1230, 1230, 12.12, 12.12, 'stiga');