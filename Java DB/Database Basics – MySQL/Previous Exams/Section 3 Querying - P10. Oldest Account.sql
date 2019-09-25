SELECT c.customer_id, c.first_name, a.start_date
FROM customers AS c
JOIN accounts AS a
ON c.customer_id = a.customer_id
ORDER BY a.start_date
LIMIT 1;