CREATE PROCEDURE usp_get_employees_by_salary_level(type_salary VARCHAR(7))
BEGIN
	CASE WHEN type_salary LIKE ('Low') THEN SELECT e.first_name, e.last_name FROM employees AS e WHERE e.salary < 30000 ORDER BY e.first_name DESC, e.last_name DESC;
	WHEN type_salary LIKE ('Average') THEN SELECT e.first_name, e.last_name FROM employees AS e WHERE e.salary >= 30000 AND e.salary <= 50000 ORDER BY e.first_name DESC, e.last_name DESC;
	WHEN type_salary LIKE ('High') THEN SELECT e.first_name, e.last_name FROM employees AS e WHERE e.salary > 50000 ORDER BY e.first_name DESC, e.last_name DESC;
    ELSE SELECT NULL;
	END CASE;
END