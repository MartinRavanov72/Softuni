CREATE PROCEDURE usp_get_towns_starting_with(first_letter VARCHAR(50))
BEGIN
	SELECT t.name AS town_name
	FROM towns AS t
	WHERE LEFT(t.name, CHAR_LENGTH(first_letter)) LIKE (first_letter)
	ORDER BY town_name;
END