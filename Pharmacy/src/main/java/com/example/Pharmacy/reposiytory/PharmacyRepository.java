package com.example.Pharmacy.reposiytory;

import com.example.Pharmacy.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {
}
