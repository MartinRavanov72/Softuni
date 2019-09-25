CREATE FUNCTION udf_concat_string(str1 VARCHAR(255), str2 VARCHAR(255))
RETURNS VARCHAR(255)
BEGIN
   DECLARE reversed_str1 VARCHAR(255);
   DECLARE reversed_str2 VARCHAR(255);
   SET reversed_str1 := REVERSE(str1);
   SET reversed_str2 := REVERSE(str2);
   RETURN CONCAT(reversed_str1, reversed_str2);
END