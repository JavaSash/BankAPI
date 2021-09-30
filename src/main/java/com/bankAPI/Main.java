package com.bankAPI;

import com.bankAPI.dao.DaoAccount;
import com.bankAPI.dao.DaoAccountImpl;
import com.bankAPI.dao.DaoCardImpl;
import com.bankAPI.model.BankAccount;
import com.bankAPI.model.BankCard;
import com.bankAPI.model.Client;

public class Main {

    public static void main(String[] args) {
        DaoAccount daoAccount = new DaoAccountImpl();
        daoAccount.dropAccountTable();
        daoAccount.createAccountTable();
        BankAccount account = new BankAccount();
        daoAccount.addAccount(account);


        DaoCardImpl daoCard = new DaoCardImpl();
//      daoCard.isExist();
        daoCard.createCardsTable();
        //BankCard card = account.issueCard();
        //daoCard.addCard(card);
//        daoCard.dropCardsTable();
        //System.out.println(daoAccount.getAllAccounts());
    }
}
