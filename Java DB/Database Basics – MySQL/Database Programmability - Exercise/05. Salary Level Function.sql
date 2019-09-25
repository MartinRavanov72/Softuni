CREATE FUNCTION ufn_get_salary_level(current_salary DOUBLE(10,2))
RETURNS VARCHAR(50)
BEGIN
    DECLARE result VARCHAR(50);
    IF current_salary < 30000 THEN SET result = 'Low';
    ELSEIF current_salary <= 50000 THEN SET result = 'Average';
    ELSE SET result = 'High';
    END IF;
    RETURN result;
END