package com.example.Pharmacy.reposiytory;

import org.springframework.stereotype.Repository;
import com.example.Pharmacy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
