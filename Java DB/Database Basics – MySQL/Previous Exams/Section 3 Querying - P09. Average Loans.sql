SELECT c.customer_id, l.amount
FROM customers AS c
INNER JOIN loans AS l
ON c.customer_id = l.customer_id
WHERE l.amount >
(
   SELECT AVG(l.amount) AS avg_amount
   FROM customers AS c
   JOIN loans AS l
   ON c.customer_id = l.customer_id
   WHERE c.gender = 'm'
)
ORDER BY c.last_name
LIMIT 5;