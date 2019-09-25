INSERT INTO issues(title, issue_status, repository_id, assignee_id)
SELECT CONCAT('Critical Problem With ', f.name, '!'), 'open', CEILING((f.id * 2)/3), c.contributor_id
FROM files AS f
JOIN commits AS c
ON f.commit_id = c.id
WHERE f.id BETWEEN 46 AND 50;