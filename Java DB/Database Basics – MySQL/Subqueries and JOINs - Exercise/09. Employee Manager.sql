SELECT e.employee_id, e.first_name, e.manager_id, (SELECT emp.first_name FROM employees AS emp WHERE emp.employee_id = e.manager_id)
FROM employees AS e
WHERE e.manager_id IN(3, 7)
ORDER BY e.first_name;