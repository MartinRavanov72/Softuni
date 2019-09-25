SELECT COUNT(c.country_code) AS asd
FROM countries AS c
LEFT JOIN mountains_countries AS mc
ON c.country_code = mc.country_code
WHERE mc.country_code IS NULL;