CREATE PROCEDURE udp_findbyextension(extension VARCHAR(255))
BEGIN
	SELECT f.id, f.name, CONCAT(f.size, 'KB') FROM files AS f WHERE f.name LIKE (CONCAT('%.', extension)) ORDER BY f.id;
END