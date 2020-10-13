package com.c0320g1.vaccine2.service;

import com.c0320g1.vaccine2.model.Account;

public interface AccountService {

    void save(Account account);

    Account findById(Long id);

   Account findAccountByEmail(String email);

   void saveAccount(Account account);

   Account findAccountByUserName(String username);
}
