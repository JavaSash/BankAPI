package com.bankAPI.service;

import com.bankAPI.dao.DaoAccount;
import com.bankAPI.dao.DaoAccountImpl;
import com.bankAPI.exception.BankApiException;
import com.bankAPI.model.BankAccount;
import com.bankAPI.model.BankCard;

import java.util.List;

public class AccountService {
    private static BankAccount account = new BankAccount();
    private static DaoAccount daoAccount = new DaoAccountImpl();

    private AccountService() {
    }

    public static BankAccount getAccount() {
        List<BankAccount> list = daoAccount.getAllAccounts();
        if (!list.contains(account)) {
            daoAccount.addAccount(account);
        }
        return account;
    }

    public static void deposit(float amount) {
        account.deposit(amount);
    }

    public static float getBalance() {
        return account.getBalance();
    }

    public static int getAccountId() {
        return daoAccount.getAccountId(account);
    }

    public static List<BankCard> getAllCards() {
        return account.getAllCards();
    }
}
