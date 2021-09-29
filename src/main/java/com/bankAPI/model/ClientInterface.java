package com.bankAPI.model;

import java.io.Serializable;
import java.util.Set;

public interface ClientInterface extends Serializable {
    BankCard issueCard();//api/bank-cards
    Set<BankCard> getAllCards();
    void deposit(float amount);
    float getBalance();
}
