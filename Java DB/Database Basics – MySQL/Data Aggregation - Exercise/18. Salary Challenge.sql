SELECT first_name, last_name, department_id
FROM employees
WHERE salary > 
(SELECT AVG(salary)
FROM employees AS e
GROUP BY department_id
HAVING e.department_id = employees.department_id)
ORDER BY department_id, employee_id
LIMIT 10;