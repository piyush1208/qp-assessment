package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Grocery;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Long> {
}
