package com.c0320g1.vaccine2.service.Impl;

import com.c0320g1.vaccine2.model.VerifyToken;
import com.c0320g1.vaccine2.repository.VerifyTokenRepository;
import com.c0320g1.vaccine2.service.VerifyTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@Transactional
public class VerifyTokenServiceImpl implements VerifyTokenService {
    @Autowired
    private VerifyTokenRepository verifyTokenRepository;

    @Override
    public void save(VerifyToken verifyToken) {
        verifyTokenRepository.save(verifyToken);
    }

    @Override
    public VerifyToken findByEmail(String email) {
        return verifyTokenRepository.findByEmail(email);
    }

    @Override
    public Boolean checkTokenVerify(String email, String code) {
        VerifyToken verifyToken1 = verifyTokenRepository.findByEmail(email);
        LocalDateTime timeNow = LocalDateTime.now();
       Duration timeEquals= Duration.between(verifyToken1.getTimeCreate(), timeNow);
        if (timeEquals.toMinutes()>5) {
            return false;
        }
        if (!verifyToken1.getCode().equals(code)) {
            return false;
        }
        return true;
    }

    @Override
    public void deleteAllByEmail(String email) {
        verifyTokenRepository.removeAllByEmail(email);
    }
}
