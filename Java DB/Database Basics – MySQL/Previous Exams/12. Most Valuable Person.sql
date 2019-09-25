SELECT s.id, u.username, p.name, CONCAT(s.passed_tests, ' / ', p.tests) as result
FROM submissions as s 
JOIN users as u ON s.user_id = u.id
JOIN problems as p ON s.problem_id = p.id
WHERE u.id = (SELECT derived.id FROM 
	(SELECT u.id, COUNT(u_c.contest_id) as count_c FROM users as u
	JOIN users_contests as u_c ON u.id = u_c.user_id
	GROUP BY u.id
	ORDER BY count_c DESC LIMIT 1) as derived)
ORDER BY s.id DESC;