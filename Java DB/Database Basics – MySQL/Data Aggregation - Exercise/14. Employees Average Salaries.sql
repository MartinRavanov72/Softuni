CREATE TABLE `pesho` AS
SELECT *
FROM employees
WHERE salary > 30000;

DELETE FROM pesho
WHERE manager_id = 42;

UPDATE pesho
SET salary = salary + 5000
WHERE department_id = 1;

SELECT department_id, AVG(salary) AS avg_salary
FROM pesho
GROUP BY department_id
ORDER BY department_id;