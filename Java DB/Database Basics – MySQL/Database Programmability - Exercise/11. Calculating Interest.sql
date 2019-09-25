CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(19, 4), interest_rate DECIMAL(7, 4), years INT)
RETURNS DECIMAL(19, 4)
BEGIN
	DECLARE output DECIMAL(19, 4);
	SET output := initial_sum * POW((1 + interest_rate), years);
	RETURN output;
END;

CREATE PROCEDURE usp_calculate_future_value_for_account(id_param INT, interest_rate DECIMAL(7, 4))
BEGIN
	SELECT acc.id AS account_id, a.first_name, a.last_name, acc.balance AS current_balance, ufn_calculate_future_value(acc.balance, interest_rate, 5) AS balance_in_5_years
	FROM account_holders AS a
	JOIN accounts AS acc
	ON a.id = acc.account_holder_id
	WHERE acc.id = id_param
	LIMIT 1;
END