CREATE TABLE users(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(30) NOT NULL,
email VARCHAR(50)
);

CREATE TABLE categories(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
parent_id INT(11) NOT NULL,
CONSTRAINT fk_categories_categories
FOREIGN KEY (parent_id) REFERENCES categories(id)
);

CREATE TABLE contests(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
category_id INT(11) NOT NULL,
CONSTRAINT fk_contests_categories
FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE problems(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100) NOT NULL,
points INT(11) NOT NULL,
tests INT(11) DEFAULT 0,
contest_id INT(11) NOT NULL,
CONSTRAINT fk_problems_contest
FOREIGN KEY (contest_id) REFERENCES contests(id)
);

CREATE TABLE submissions(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
passed_tests INT(11) NOT NULL,
problem_id INT(11) NOT NULL,
user_id INT(11) NOT NULL,
CONSTRAINT fk_submissions_problems
FOREIGN KEY (problem_id) REFERENCES problems(id),
CONSTRAINT fk_submissions_users
FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE users_contests(
user_id INT(11) NOT NULL,
contest_id INT(11) NOT NULL,
CONSTRAINT pk_user_contests
PRIMARY KEY (user_id, contest_id),
CONSTRAINT fk_user_contests_users
FOREIGN KEY (user_id) REFERENCES users(id),
CONSTRAINT fk_user_contests_contests
FOREIGN KEY (contest_id) REFERENCES contests(id)
);