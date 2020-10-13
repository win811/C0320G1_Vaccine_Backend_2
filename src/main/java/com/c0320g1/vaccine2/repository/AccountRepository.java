package com.c0320g1.vaccine2.repository;

import com.c0320g1.vaccine2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    //creator: Tiến
    Account findByUsernameAndConfirmStatusIsTrue(String name);

    //creator: Tien
    Account findByEmail(String email);

    Account findByUsername(String username);
}
