package com.bankAPI.model;

import com.bankAPI.util.numberGenerator;

public class BankCard {
    //TODO: addAccount date of card issue
    private int cardId;
    private String cardNumber;
    private int accountId;

    BankCard(BankAccount account) {
        cardNumber = numberGenerator.generateCardNumber();
        cardId = account.getCardInstances();
        accountId = account.getAccountId();
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankCard bankCard = (BankCard) o;

        if (cardId != bankCard.cardId) return false;
        return cardNumber.equals(bankCard.cardNumber);
    }

    @Override
    public int hashCode() {
        int result = cardId;
        result = 31 * result + cardNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "cardId = '" + cardId + '\'' +
                "cardNumber = '" + cardNumber + '\'' +
                '}';
    }
}
