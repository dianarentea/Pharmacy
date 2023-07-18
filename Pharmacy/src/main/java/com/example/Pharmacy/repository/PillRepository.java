package com.example.Pharmacy.repository;


import com.example.Pharmacy.model.Pill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PillRepository extends JpaRepository<Pill, Integer>{
}