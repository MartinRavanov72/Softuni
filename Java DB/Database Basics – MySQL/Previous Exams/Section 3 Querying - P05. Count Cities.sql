SELECT c.city_name, b.name, COUNT(*) AS employees_count
FROM employees AS e 
JOIN branches AS b
ON e.branch_id = b.branch_id
JOIN cities AS c
ON c.city_id = b.city_id
WHERE c.city_id NOT IN (4,5)
GROUP BY c.city_name, b.name
HAVING COUNT(*) >= 3;