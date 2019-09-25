SELECT * FROM 
	(SELECT c.id, c.name, COUNT(u_c.user_id) as contestants FROM contests as c 
	LEFT JOIN users_contests as u_c ON c.id = u_c.contest_id
	GROUP BY u_c.contest_id
	ORDER BY contestants DESC LIMIT 5) as derived
ORDER BY contestants, id;