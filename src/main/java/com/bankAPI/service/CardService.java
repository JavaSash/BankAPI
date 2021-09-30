package com.bankAPI.service;

import com.bankAPI.dao.DaoCard;
import com.bankAPI.dao.DaoCardImpl;
import com.bankAPI.model.BankCard;

import java.util.List;

public class CardService {
    private static DaoCard daoCard = new DaoCardImpl();

    private CardService() {
    }

    public static BankCard issueCard() {
        BankCard card = AccountService.getAccount().issueCard();
        daoCard.addCard(card);
        return card;
    }

    public static void deposit(float amount) {
        AccountService.deposit(amount);
    }

    public static List<BankCard> getAllCards() {
        return AccountService.getAllCards();
    }

}
