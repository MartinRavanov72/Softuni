SELECT r.id, r.name, COUNT(u.id) AS users
FROM repositories AS r
LEFT JOIN
(SELECT * FROM commits AS cc GROUP BY cc.repository_id, cc.contributor_id) AS c
ON r.id = c.repository_id
LEFT JOIN users AS u
ON c.contributor_id = u.id
GROUP BY r.id
ORDER BY users DESC, r.id;