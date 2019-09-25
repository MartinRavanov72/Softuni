SELECT c.customer_id, c.first_name, c.last_name, c.gender, ci.city_name
FROM customers AS c 
JOIN cities AS ci
ON c.city_id = ci.city_id
WHERE (c.last_name LIKE ('Bu%') OR RIGHT(c.first_name, 1) LIKE 'a') AND CHAR_LENGTH(ci.city_name) > 7
ORDER BY c.customer_id;