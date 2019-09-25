UPDATE repositories_contributors
SET repository_id = (
	SELECT r.id
	FROM repositories AS r
	LEFT JOIN (SELECT * FROM repositories_contributors) AS rc
	ON rc.repository_id = r.id
	WHERE rc.repository_id IS NULL
	ORDER BY r.id
	LIMIT 1
)
WHERE repository_id = contributor_id;
