(
SELECT e.first_name, c.city_name
FROM employees AS e
JOIN branches AS b
ON e.branch_id = b.branch_id
JOIN cities AS c
ON c.city_id = b.city_id
LIMIT 3
)
 
UNION ALL
 
(
SELECT cu.first_name, ci.city_name
FROM customers AS cu
JOIN cities AS ci
ON cu.city_id = ci.city_id
LIMIT 3
);