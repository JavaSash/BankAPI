package com.bankAPI.model;

import java.io.Serializable;
import java.util.List;

public interface ClientInterface extends Serializable {
    BankCard issueCard();//api/bank-cards
    List<BankCard> getAllCards();
    void deposit(float amount);
    float getBalance();
}
