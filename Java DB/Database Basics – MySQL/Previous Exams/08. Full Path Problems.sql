SELECT p.id, CONCAT(ca.name, ' - ', co.name, ' - ', p.name) AS full_time
FROM problems AS p
JOIN contests AS co ON p.contest_id = co.id
JOIN categories AS ca ON ca.id = co.category_id
ORDER BY p.id;