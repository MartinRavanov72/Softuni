CREATE TABLE directors(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
director_name VARCHAR(50) NOT NULL,
notes LONGTEXT
);

CREATE TABLE genres(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
genre_name VARCHAR(50) NOT NULL,
notes LONGTEXT
);

CREATE TABLE categories(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
category_name VARCHAR(50) NOT NULL,
notes LONGTEXT
);

CREATE TABLE movies(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
title VARCHAR(50) NOT NULL,
director_id INT NOT NULL,
copyright_year YEAR,
`length` TIME,
genre_id INT NOT NULL,
category_id INT NOT NULL,
rating TINYINT(10),
notes LONGTEXT
);

INSERT INTO directors(director_name, notes)
VALUES('pesho', 's'),
('pesho', 's'),
('pesho', 's'),
('pesho', 's'),
('pesho', 's');

INSERT INTO genres(genre_name, notes)
VALUES('pesho', 's'),
('pesho', 's'),
('pesho', 's'),
('pesho', 's'),
('pesho', 's');

INSERT INTO categories(category_name, notes)
VALUES('pesho', 's'),
('pesho', 's'),
('pesho', 's'),
('pesho', 's'),
('pesho', 's');

INSERT INTO movies(title, director_id, copyright_year, `length`, genre_id, category_id, rating, notes)
VALUES('pesho', 1, 1999, '13:56:38', 1, 1, 8, 'hubav'),
('pesho', 1, 1999, '13:56:38', 1, 1, 8, 'hubav'),
('pesho', 1, 1999, '13:56:38', 1, 1, 8, 'hubav'),
('pesho', 1, 1999, '13:56:38', 1, 1, 8, 'hubav'),
('pesho', 1, 1999, '13:56:38', 1, 1, 8, 'hubav');