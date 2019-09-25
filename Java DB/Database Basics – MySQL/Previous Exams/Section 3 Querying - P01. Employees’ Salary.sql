SELECT employee_id,hire_date,salary,branch_id
 FROM employees AS e
WHERE e.salary > 2000
AND e.hire_date > '2009-06-15'