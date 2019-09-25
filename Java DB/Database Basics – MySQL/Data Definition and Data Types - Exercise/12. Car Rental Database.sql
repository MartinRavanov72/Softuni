CREATE TABLE categories(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
category VARCHAR(50) NOT NULL,
daily_rate TINYINT(10),
weekly_rate TINYINT(10),
monthly_rate TINYINT(10),
weekend_rate TINYINT(10)
);

CREATE TABLE cars(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
plate_number INT UNIQUE NOT NULL,
make VARCHAR(50) NOT NULL,
model VARCHAR(50) NOT NULL,
car_year YEAR,
category_id INT NOT NULL,
doors TINYINT(6),
picture BLOB,
car_condition VARCHAR(50),
available ENUM('yes','no')
);

CREATE TABLE employees(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
title VARCHAR(50) NOT NULL,
notes LONGTEXT
);

CREATE TABLE customers(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
driver_licence_number INT NOT NULL,
full_name VARCHAR(50) NOT NULL,
address VARCHAR(50),
city VARCHAR(50),
zip_code INT,
notes LONGTEXT
);


CREATE TABLE rental_orders(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
employee_id INT NOT NULL,
customer_id INT NOT NULL,
car_id INT NOT NULL,
car_condition VARCHAR(50),
tank_level TINYINT(10),
kilometrage_start INT NOT NULL,
kilometrage_end INT,
total_kilometrage INT,
start_date DATE NOT NULL,
end_date DATE,
total_days INT,
rate_applied TINYINT(10),
tax_rate INT,
order_status VARCHAR(50) NOT NULL,
notes LONGTEXT
);

INSERT INTO categories(category, daily_rate, weekly_rate, monthly_rate, weekend_rate)
VALUES('a', 3, 3, 3, 3),
('a', 3, 3, 3, 3),
('a', 3, 3, 3, 3);

INSERT INTO cars(plate_number, make, model, car_year, category_id, doors, picture, car_condition, available)
VALUES(123, 'ivan', 'ivan', 1999, 1, 5, NULL, 'good', 'yes'),
(1233, 'ivan', 'ivan', 1999, 1, 5, NULL, 'good', 'yes'),
(12333, 'ivan', 'ivan', 1999, 1, 5, NULL, 'good', 'yes');

INSERT INTO employees(first_name, last_name, title, notes)
VALUES('pesho', 's', 'chistach', 'd'),
('pesho', 's', 'chistach', 'd'),
('pesho', 's', 'chistach', 'd');

INSERT INTO customers(driver_licence_number, full_name, address, city, zip_code, notes)
VALUES(123, 'pesho', 'lulin', 'lulin', 1999, 'hubav'),
(123, 'pesho', 'lulin', 'lulin', 1999, 'hubav'),
(123, 'pesho', 'lulin', 'lulin', 1999, 'hubav');

INSERT INTO rental_orders (employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes)
VALUES(1, 1, 1, 'dobre', 6, 11212, 12122, 1000, '1999-12-12', '1999-12-11', 1, 11, 20, 'ended', 'good'),
(1, 1, 1, 'dobre', 6, 11212, 12122, 1000, '1999-12-12', '1999-12-11', 1, 11, 20, 'ended', 'good'),
(1, 1, 1, 'dobre', 6, 11212, 12122, 1000, '1999-12-12', '1999-12-11', 1, 11, 20, 'ended', 'good');