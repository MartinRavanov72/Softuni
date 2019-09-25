SELECT c.id, c.name
FROM categories AS c
WHERE (SELECT COUNT(*) FROM categories AS cat WHERE cat.parent_id = c.id) = 0
ORDER BY c.name, c.id;