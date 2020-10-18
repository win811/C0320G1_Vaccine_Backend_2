package com.c0320g1.vaccine2.controller;

import com.c0320g1.vaccine2.dto.JwtRequest;
import com.c0320g1.vaccine2.dto.JwtResponse;
import com.c0320g1.vaccine2.model.Account;
import com.c0320g1.vaccine2.security.JwtTokenUtil;
import com.c0320g1.vaccine2.security.MyUserDetailsService;
import com.c0320g1.vaccine2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired(required = false)
    private AuthenticationManager authenticationManager;

    @Autowired(required = false)
    private MyUserDetailsService userDetailServiceImpl;


    @PostMapping(value = "/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword())
        );
        UserDetails userDetails = userDetailServiceImpl.loadUserByUsername(authentication.getName());
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        Account accountLogin = accountService.findAccountByUserName(userDetails.getUsername());
        return ResponseEntity.ok(new JwtResponse(jwtToken, accountLogin.getId(), accountLogin.getFullName(), userDetails.getUsername(),accountLogin.getAvatar(), userDetails.getAuthorities()));
    }
}
