CREATE FUNCTION ufn_calculate_future_value(initial_sum DOUBLE(19, 2), interest_rate DOUBLE, years INT)
RETURNS DOUBLE(19, 2)
BEGIN
	DECLARE output DOUBLE(19, 2);
	SET output := initial_sum * POW((1 + interest_rate), years);
	RETURN ROUND(output, 2);
END