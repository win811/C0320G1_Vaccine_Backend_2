package com.c0320g1.vaccine2.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 6)
    private String username;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @Column(nullable = false)
    @Size(min = 10)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String idCard;

    private String address;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    private String gender;

    private LocalDate birthDay;

    private String avatar;

    @Pattern(regexp = "^(ROLE_USER|ROLE_ADMIN)$")
    private String role ;

    private String phoneNumber;

    private boolean confirmStatus = false;
}
