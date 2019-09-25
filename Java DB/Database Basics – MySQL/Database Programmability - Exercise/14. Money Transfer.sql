CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, money_amount DECIMAL(17, 4))
BEGIN
	START TRANSACTION;
	IF money_amount <= 0 
	OR (SELECT a.balance FROM accounts AS a WHERE a.id = from_account_id) < money_amount 
	OR (SELECT COUNT(a.id) FROM accounts AS a) < to_account_id 
	OR (SELECT COUNT(a.id) FROM accounts AS a) < from_account_id
	OR from_account_id < 1
	OR to_account_id < 1
	OR from_account_id = to_account_id
	THEN
	ROLLBACK;
	ELSE
		UPDATE accounts AS a
		SET a.balance = a.balance - money_amount
		WHERE a.id = from_account_id;
		UPDATE accounts AS a
		SET a.balance = a.balance + money_amount
		WHERE a.id = to_account_id;
	END IF;
END