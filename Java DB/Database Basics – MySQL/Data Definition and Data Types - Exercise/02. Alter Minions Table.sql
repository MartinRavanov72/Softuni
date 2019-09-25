ALTER TABLE minions
ADD town_id INT;

ALTER TABLE minions
ADD CONSTRAINT minions_town_id_FK FOREIGN KEY (town_id) REFERENCES towns(id);