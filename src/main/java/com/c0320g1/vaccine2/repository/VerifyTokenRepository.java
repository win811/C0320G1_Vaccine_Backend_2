package com.c0320g1.vaccine2.repository;

import com.c0320g1.vaccine2.model.VerifyToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifyTokenRepository extends JpaRepository<VerifyToken, Long> {
    VerifyToken findByEmail(String email);

    void removeAllByEmail(String email);
}
