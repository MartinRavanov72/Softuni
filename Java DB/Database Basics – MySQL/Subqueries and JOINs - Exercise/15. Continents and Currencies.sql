SELECT c2.continent_code, c2.currency_code, c2.currency_usage
FROM (
        SELECT c.continent_code, c.currency_code, MAX(c.currency_usage) AS currency_usage
        FROM (
                SELECT continent_code, currency_code, count(currency_code) AS currency_usage
                FROM countries
                GROUP BY continent_code, currency_code
        ) AS c
        GROUP BY c.continent_code
        HAVING currency_usage != 1
        ) AS c1
JOIN (
        SELECT continent_code, currency_code, count(currency_code) AS currency_usage
        FROM countries
        GROUP BY continent_code, currency_code
        ) AS c2
ON c1.continent_code = c2.continent_code
WHERE c2.currency_usage = c1.currency_usage
ORDER BY c2.continent_code, c2.currency_usage;