CREATE PROCEDURE udp_commit(username VARCHAR(255), `password` VARCHAR(255), message VARCHAR(255), issue_id INT(11))
BEGIN
	CASE WHEN (SELECT u.id FROM users AS u WHERE u.username = username) IS NULL
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No such user!';
	WHEN (SELECT u.id FROM users AS u WHERE u.username = username AND u.`password` = `password`) IS NULL 
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Password is incorrect!';
	WHEN (SELECT i.id FROM issues AS i WHERE i.id = issue_id) IS NULL
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The issue does not exist!';
	ELSE
	INSERT INTO commits(message, issue_id, repository_id, contributor_id)
	VALUES(message, issue_id, (SELECT i.repository_id FROM issues AS i WHERE i.id = issue_id), (SELECT u.id FROM users AS u WHERE u.username = username));
	UPDATE issues AS i SET issue_status = 'closed' WHERE i.id = issue_id;
	END CASE;
END