CREATE TABLE persons(
person_id INT NOT NULL,
first_name VARCHAR(30) NOT NULL,
salary DECIMAL(10, 2) UNSIGNED NOT NULL,
passport_id INT UNSIGNED UNIQUE NOT NULL
);

CREATE TABLE passports(
passport_id INT UNSIGNED UNIQUE NOT NULL,
passport_number VARCHAR(100) UNIQUE
);

INSERT INTO persons(person_id, first_name, salary, passport_id)
VALUES(1, 'Roberto', 43300.00, 102),
(2, 'Tom', 56100.00, 103),
(3, 'Yana', 60200.00, 101);

INSERT INTO passports(passport_id, passport_number)
VALUES(101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

ALTER TABLE persons
ADD PRIMARY KEY (person_id);

ALTER TABLE persons
ADD CONSTRAINT FOREIGN KEY (passport_id) REFERENCES passports(passport_id);
