SELECT LEFT(f.name, LOCATE('.', f.name) - 1) AS `file`, 
(
SELECT COUNT(*)
FROM commits AS c
WHERE c.message LIKE (CONCAT('%', f.name, '%'))
) AS recursive_count
FROM files AS f
JOIN files AS ff
ON ff.parent_id = f.id AND f.parent_id = ff.id
WHERE f.id != f.parent_id
ORDER BY f.name;