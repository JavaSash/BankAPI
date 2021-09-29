package com.bankAPI.dao;

import com.bankAPI.model.BankAccount;
import com.bankAPI.model.BankCard;

import java.util.List;

public interface DaoCard {
    //create
    void createCardsTable();
    void addCard(BankCard card);

    //read
    List<BankCard> getAllCardsByAccountId(int id);
    BankCard getCardById(int id);

    //update
    void updateCard(BankCard card);

    //delete
    void dropCardsTable();
    void removeCard(BankCard card);
    void clearCardsTable();
}
