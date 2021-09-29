package com.bankAPI.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
//TODO: нужно ли сериализовать клиента?
public class Client implements Serializable {
    private final String uuid;
    private String fullName;
    private String login;
    private String password;
    private BankAccount account;

    private Client(String uuid, String fullName, String login, String password) {
        Objects.requireNonNull(fullName);
        Objects.requireNonNull(uuid);
        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.uuid = uuid;
        account = new BankAccount(fullName);
    }

    public Client(String fullName, String login, String password) {
        this(UUID.randomUUID().toString(), fullName, "UserLogin", "password");
    }

    public Client(String fullName) {
        this(fullName, "UserLogin", "password");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        login = login;
    }

    public void setPassword(String password) {
        password = password;
    }

    public BankAccount getAccount() {
        return account;
    }

    public String getUuid() {
        return uuid;
    }



    @Override
    public String toString() {
        return "Client{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", account=" + account +
                '}';
    }

    public int compareTo(Client client) {
        return fullName.equalsIgnoreCase(client.getFullName()) ?
                uuid.compareTo(client.getUuid()) :
                fullName.compareTo(client.getFullName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!uuid.equals(client.uuid)) return false;
        if (!fullName.equals(client.fullName)) return false;
        if (login != null ? !login.equals(client.login) : client.login != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null) return false;
        return account.equals(client.account);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + account.hashCode();
        return result;
    }
}
