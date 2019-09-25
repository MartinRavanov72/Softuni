CREATE TABLE projects(
id INT(11) UNSIGNED NOT NULL PRIMARY KEY,
client_id INT(11) UNSIGNED NOT NULL,
project_lead_id INT(11) UNSIGNED NOT NULL
);

CREATE TABLE clients(
id INT(11) UNSIGNED NOT NULL UNIQUE PRIMARY KEY,
client_name VARCHAR(100),
project_id INT(11) UNSIGNED NOT NULL,
CONSTRAINT fk_projects_clients
FOREIGN KEY	(project_id)
REFERENCES projects(id)
);

CREATE TABLE employees(
id INT(11) UNSIGNED NOT NULL UNIQUE PRIMARY KEY,
first_name VARCHAR(30),
last_name VARCHAR(30),
project_id INT(11) UNSIGNED NOT NULL,
CONSTRAINT fk_projects_employees
FOREIGN KEY (project_id)
REFERENCES projects(id)
);