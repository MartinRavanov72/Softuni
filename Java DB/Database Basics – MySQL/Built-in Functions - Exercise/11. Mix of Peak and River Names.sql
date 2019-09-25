SELECT peaks.peak_name, rivers.river_name, LOWER(CONCAT(SUBSTRING(peak_name, 1, CHAR_LENGTH(peak_name) - 1), '', river_name)) AS mix 
FROM peaks, rivers 
WHERE RIGHT(peak_name, 1) LIKE LEFT(river_name, 1) 
ORDER BY mix;