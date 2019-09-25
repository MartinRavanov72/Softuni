SELECT u.id, u.username, u.`password`
FROM users AS u
WHERE (SELECT COUNT(*) FROM users AS us WHERE us.`password` = u.`password`) > 1
ORDER BY u.username, u.id;