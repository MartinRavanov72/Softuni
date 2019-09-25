package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}