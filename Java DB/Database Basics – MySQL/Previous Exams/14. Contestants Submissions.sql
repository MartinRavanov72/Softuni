SELECT c.id, c.name, COUNT(s.id) as `submissions` FROM contests as c 
JOIN problems as p ON c.id = p.contest_id 
JOIN submissions as s ON s.problem_id = p.id AND 
	(SELECT contest_id FROM users_contests 
	WHERE s.user_id = user_id AND p.contest_id = contest_id 
	LIMIT 1) IS NOT NULL
GROUP BY c.id, c.name
ORDER BY `submissions` DESC, id;