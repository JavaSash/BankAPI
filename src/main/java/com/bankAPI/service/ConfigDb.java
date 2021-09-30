package com.bankAPI.service;

import com.bankAPI.Config;
import com.bankAPI.dao.DaoAccount;
import com.bankAPI.dao.DaoAccountImpl;
import com.bankAPI.dao.DaoCard;
import com.bankAPI.dao.DaoCardImpl;
import com.bankAPI.model.BankAccount;
import com.bankAPI.model.BankCard;

public class ConfigDb {
    private static DaoAccount daoAccount = new DaoAccountImpl();
    private static DaoCard daoCard = new DaoCardImpl();

    private ConfigDb() {
    }

    public static void clearDb() {
        daoAccount.dropAccountTable();
        daoCard.dropCardsTable();
    }

    public static void setDefaultConfigDb () {
        daoAccount.dropAccountTable();
        daoAccount.createAccountTable();
//        BankAccount account = new BankAccount();
//        daoAccount.addAccount(account);

        daoCard.dropCardsTable();
        daoCard.createCardsTable();
//        BankCard card = account.issueCard();
//        daoCard.addCard(card);
    }
}
