SELECT campers.id AS driver_id, vehicles.vehicle_type AS vehicle_type, CONCAT(campers.first_name, ' ', campers.last_name) AS driver_name
FROM campers
JOIN vehicles 
ON vehicles.driver_id = campers.id;