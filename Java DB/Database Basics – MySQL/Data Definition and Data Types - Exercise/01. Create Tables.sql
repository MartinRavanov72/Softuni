CREATE TABLE minions(
id INT,
name VARCHAR(50),
age INT
);

ALTER TABLE minions
ADD PRIMARY KEY(id);

CREATE TABLE towns(
id INT,
name VARCHAR(50)
);

ALTER TABLE towns
ADD PRIMARY KEY(id);