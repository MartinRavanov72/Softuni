SELECT r.id AS id, r.name, (
	SELECT COUNT(cc.id)
	FROM repositories AS rr
	JOIN commits AS cc
	ON rr.id = cc.repository_id
	WHERE rr.id = r.id
	GROUP BY rr.name
) AS `commits`, COUNT(rc.contributor_id) AS `contributors`
FROM repositories AS r
JOIN repositories_contributors AS rc
ON r.id = rc.repository_id
GROUP BY r.name
ORDER BY contributors DESC, r.id
LIMIT 1;