package com.bankAPI.dao;

import com.bankAPI.model.BankAccount;

import java.util.List;

/**
 * Data access interface
 */
public interface DaoAccount {
    //create
    void createAccountTable();
    void addAccount(BankAccount account);

    //read
    List<BankAccount> getAllAccounts();
    BankAccount getAccountById(int id);

    //update
    void updateAccount(BankAccount account);

    //delete
    void dropAccountTable();
    void removeAccount(BankAccount account);
    void clearAccountTable();
}
