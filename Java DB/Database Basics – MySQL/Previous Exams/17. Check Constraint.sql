CREATE TRIGGER my_trigger BEFORE INSERT ON problems
FOR EACH ROW
BEGIN 
	CASE WHEN NEW.name NOT LIKE '% %'
		THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The given name is invalid!';
	WHEN NEW.points = 0
		THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The problem’s points cannot be less or equal to 0!';
	WHEN NEW.tests = 0
		THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The problem’s tests cannot be less or equal to 0!';
	ELSE BEGIN END;
END CASE;
END