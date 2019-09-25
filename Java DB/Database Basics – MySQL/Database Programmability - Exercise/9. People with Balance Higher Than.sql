CREATE PROCEDURE usp_get_holders_with_balance_higher_than(param DOUBLE(10, 2))
BEGIN
	SELECT a.first_name, a.last_name
	FROM account_holders AS a 
	JOIN accounts AS acc 
	ON a.id = acc.account_holder_id
	GROUP BY a.id
	HAVING SUM(acc.balance) > param
	ORDER BY acc.id, a.first_name;
END