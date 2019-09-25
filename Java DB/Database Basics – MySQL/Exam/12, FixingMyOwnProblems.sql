SELECT u.id, u.username, CASE
	(SELECT COUNT(*) AS commitss
	FROM users AS uu
	LEFT JOIN issues AS ii
	ON ii.assignee_id = uu.id
	LEFT JOIN commits AS cc
	ON ii.id = cc.issue_id
	WHERE uu.id = u.id AND cc.contributor_id = uu.id
	GROUP BY uu.id) 
WHEN 1 THEN 1
ELSE 0
END AS commits
FROM users AS u
LEFT JOIN issues AS i
ON i.assignee_id = u.id
LEFT JOIN commits AS c
ON i.id = c.issue_id
GROUP BY u.id
ORDER BY commits DESC, u.id;