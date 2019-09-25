CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DOUBLE(17, 4))
BEGIN
	START TRANSACTION;
	IF money_amount < 0 THEN
	ROLLBACK;
	ELSE
		UPDATE accounts AS a
		SET a.balance = a.balance + ABS(money_amount)
		WHERE a.id = account_id;
	END IF;
END