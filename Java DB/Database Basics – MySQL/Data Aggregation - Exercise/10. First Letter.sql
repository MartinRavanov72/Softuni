SELECT
LEFT(first_name, 1) AS 'first_letter'
FROM wizzard_deposits
WHERE deposit_group LIKE ('Troll Chest')
GROUP BY LEFT(first_name, 1)
ORDER BY first_letter;