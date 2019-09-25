SELECT SUM(diff.difference) AS sum_difference
FROM 
	(SELECT wd1.deposit_amount - wd2.deposit_amount AS difference
	FROM wizzard_deposits AS wd1, wizzard_deposits AS wd2
	WHERE wd2.id - wd1.id = 1) AS diff;