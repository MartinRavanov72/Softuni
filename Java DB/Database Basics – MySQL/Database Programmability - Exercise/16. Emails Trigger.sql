CREATE TABLE `logs`(
log_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
account_id INT,
old_sum DECIMAL(17, 4),
new_sum DECIMAL(17, 4)
);

CREATE TABLE notification_emails(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
recipient INT,
subject TEXT,
body TEXT
);

CREATE TRIGGER tr_send_email
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
INSERT INTO notification_emails(recipient, subject, body)
SELECT l.account_id, CONCAT('Balance change for account: ', l.account_id), CONCAT('On ', NOW(), ' your balance was changed from ', l.old_sum, ' to ', l.new_sum)
FROM `logs` AS l;
END
