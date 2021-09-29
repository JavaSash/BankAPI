package com.bankAPI;

import com.bankAPI.dao.DaoAccount;
import com.bankAPI.dao.DaoAccountImpl;
import com.bankAPI.model.BankAccount;
import com.bankAPI.model.Client;

public class Main {
    public static final String FULL_NAME = "Игнат Галушко";
    public static void main(String[] args) {
        Client client = new Client(FULL_NAME);
        client.getAccount().issueCard();
        DaoAccount daoAccount = new DaoAccountImpl();
        daoAccount.dropAccountTable();
        daoAccount.createAccountTable();
        BankAccount account = new BankAccount("Valera");
        daoAccount.addAccount(account);

        System.out.println(daoAccount.getAllAccounts());
    }
}
