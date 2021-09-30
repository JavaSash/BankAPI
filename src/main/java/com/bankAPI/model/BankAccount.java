package com.bankAPI.model;

import com.bankAPI.exception.BankApiException;
import com.bankAPI.util.numberGenerator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

//TODO: addAccount Logger
public class BankAccount implements ClientInterface {
    private static int accInstances = 0;
    private static int cardInstances = 0;
    private int accountId;
    private String accountNumber;
    private String ownersFullName;
    private List<BankCard> cards = new ArrayList<>();
    private float balance = .0f;

    public BankAccount(String fullName) {
        accInstances++;
        accountId = accInstances;
        accountNumber = numberGenerator.generateAccountNumber();
        ownersFullName = fullName;
    }

    public BankAccount() {
        this("Default Name");
    }

    @Override
    public BankCard issueCard() {
        cardInstances++;
        BankCard card = new BankCard(this);
        cards.add(card);
        return card;
    }

    @Override
    public List<BankCard> getAllCards() {
        return cards;
    }

    @Override
    public void deposit(float amount) {
        if(amount <= 0) {
            throw new BankApiException("Amount should be more than 0", String.valueOf(accountId));
        }
        balance += amount;
    }

    @Override
    public float getBalance() {
        return balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int id) {
        accountId = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnersFullName() {
        return ownersFullName;
    }

    public void setOwnersFullName(String ownersFullName) {
        this.ownersFullName = ownersFullName;
    }

    public List<BankCard> getCards() {
        return cards;
    }

    public void setCards(List<BankCard> cards) {
        this.cards = cards;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public static int getCardInstances() {
        return cardInstances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount account = (BankAccount) o;

        if (accountId != account.accountId) return false;
        if (!accountNumber.equals(account.accountNumber)) return false;
        return ownersFullName.equals(account.ownersFullName);
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + accountNumber.hashCode();
        result = 31 * result + ownersFullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId = '" + accountId + '\'' +
                "accountNumber = '" + accountNumber + '\'' +
                ", ownersFullName = '" + ownersFullName + '\'' +
                ", balance = '" + balance + '\'' +
                ", cards = " + cards +
                '}';
    }
}
