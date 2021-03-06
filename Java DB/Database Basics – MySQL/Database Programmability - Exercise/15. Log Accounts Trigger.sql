CREATE TABLE `logs`(
log_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
account_id INT,
old_sum DECIMAL(17, 4),
new_sum DECIMAL(17, 4)
);

CREATE TRIGGER tr_changed_balances
AFTER UPDATE
ON accounts
FOR EACH ROW
BEGIN
INSERT INTO `logs`(account_id, old_sum, new_sum)
VALUES(OLD.id, OLD.balance, NEW.balance);
END