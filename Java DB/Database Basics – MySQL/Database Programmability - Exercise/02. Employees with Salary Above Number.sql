CREATE PROCEDURE usp_get_employees_salary_above(min_salary DOUBLE)
BEGIN
	SELECT e.first_name, e.last_name
	FROM employees AS e
	WHERE e.salary >= min_salary
	ORDER BY e.first_name, e.last_name, e.employee_id;
END