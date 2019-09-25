CREATE PROCEDURE udp_evaluate(id INT)
BEGIN 
	CASE WHEN (SELECT id FROM submissions as s WHERE s.id = id) IS NULL
		THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Submission does not exist!';
	ELSE 
		INSERT INTO evaluated_submissions (id, problem, `user`, result) 
		SELECT s.id, p.name, u.username, CEIL(p.points / p.tests * s.passed_tests) FROM submissions as s 
		JOIN users as u ON s.user_id = u.id
		JOIN problems as p ON s.problem_id = p.id
		WHERE s.id = id;
	END CASE;
END