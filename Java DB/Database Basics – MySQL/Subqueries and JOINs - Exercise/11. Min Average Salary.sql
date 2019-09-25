SELECT MIN(avg_val) AS min_average_salary
FROM (SELECT AVG(salary) avg_val FROM employees GROUP BY department_id) tmp; 	