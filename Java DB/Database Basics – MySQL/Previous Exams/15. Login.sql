CREATE PROCEDURE udp_login(username VARCHAR(30), `password` VARCHAR(30))
BEGIN 
	CASE WHEN (SELECT id FROM users as u WHERE u.username = username) IS NULL
		THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Username does not exist!';
	   WHEN (SELECT id FROM users as u WHERE u.username = username AND u.`password` = `password`) IS NULL 
	      THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Password is incorrect!';
	   WHEN (SELECT id FROM logged_in_users as l WHERE l.username = username) IS NOT NULL
	      THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'User is already logged in!';
	   ELSE 
		 INSERT INTO logged_in_users (id, username, `password`, email) 
		 SELECT u.id, u.username, u.`password`, u.email FROM users as u
		 WHERE u.username = username;
	END CASE;
END