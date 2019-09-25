CREATE TABLE users(
id BIGINT UNIQUE AUTO_INCREMENT,
username CHAR(30) UNIQUE NOT NULL,
`password` CHAR(26) NOT NULL,
profile_picture BLOB,
last_login_time DATETIME,
is_deleted BIT
);

ALTER TABLE users
ADD PRIMARY KEY(id);

INSERT INTO users(username, `password`, profile_picture, last_login_time, is_deleted)
VALUES('a', 'b', 'picture', '2018-01-26 20:57:23', 1),
('v', 'b', 'picture', '2018-01-26 20:57:23', 1),
('as', 'b', 'picture', '2018-01-26 20:57:23', 1),
('asas', 'b', 'picture', '2018-01-26 20:57:23', 1),
('asasasas', 'b', 'picture', '2018-01-26 20:57:23', 1);