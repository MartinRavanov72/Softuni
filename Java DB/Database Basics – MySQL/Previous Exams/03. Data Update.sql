UPDATE problems AS pr
JOIN contests AS co ON pr.contest_id = co.id
JOIN categories AS ca ON co.category_id = ca.id
SET pr.tests = CASE pr.id % 3
	WHEN 0 THEN CHAR_LENGTH(ca.name)	
	WHEN 1 THEN (
		SELECT SUM(s.id)
		FROM submissions AS s
		WHERE s.problem_id = pr.id)
	WHEN 2 THEN CHAR_LENGTH(co.name)
	END
WHERE pr.tests = 0;
