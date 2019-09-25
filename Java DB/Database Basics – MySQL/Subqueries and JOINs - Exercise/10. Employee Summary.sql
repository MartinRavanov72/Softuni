SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS employee_name, (SELECT CONCAT(emp.first_name, ' ', emp.last_name) FROM employees AS emp WHERE emp.employee_id = e.manager_id) AS manager_name, d.name AS department_name
FROM employees AS e
JOIN departments AS d
ON e.department_id = d.department_id
WHERE e.manager_id IS NOT NULL
ORDER BY e.employee_id
LIMIT 5;