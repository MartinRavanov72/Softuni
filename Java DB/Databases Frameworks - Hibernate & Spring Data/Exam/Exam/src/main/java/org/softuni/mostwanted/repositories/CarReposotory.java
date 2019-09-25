package org.softuni.mostwanted.repositories;

import org.softuni.mostwanted.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarReposotory extends JpaRepository<Car, Integer>{
    Car findById(Integer id);
}
