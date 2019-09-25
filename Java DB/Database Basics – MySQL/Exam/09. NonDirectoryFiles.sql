SELECT f.id, f.name, CONCAT(f.size, 'KB') AS size
FROM files AS f
WHERE (SELECT COUNT(*) FROM files AS fi WHERE fi.parent_id = f.id) = 0
ORDER BY f.id;