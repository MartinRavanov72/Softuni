CREATE TABLE people(
id INT UNIQUE AUTO_INCREMENT,
name VARCHAR(200) NOT NULL,
picture BLOB(2048),
height DECIMAL(5,2),
weight DECIMAL(5,2),
gender CHAR(1) NOT NULL,
birthdate DATE NOT NULL,
biography TEXT);

ALTER TABLE people
ADD PRIMARY KEY(id);

INSERT INTO people(name, picture, height, weight, gender, birthdate, biography)
VALUES('a', '43006F006E0066006900', 123.12, 123.12, 'm', '1999-12-12', 'a'),
('b', '43006F006E0066006900', 123.12, 123.12, 'm', '1999-12-12', 'a'),
('c', '43006F006E0066006900', 123.12, 123.12, 'm', '1999-12-12', 'a'),
('d', '43006F006E0066006900', 123.12, 123.12, 'm', '1999-12-12', 'a'),
('e', '43006F006E0066006900', 123.12, 123.12, 'm', '1999-12-12', 'a');