package com.bankAPI.dao;

import com.bankAPI.exception.BankApiException;
import com.bankAPI.model.BankAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.bankAPI.util.ConnectionUtil.getConnection;

/**
 * Класс, реализующий взаимодействия с таблицей аккаунтов в БД
 */
public class DaoAccountImpl implements DaoAccount {
    private static final String createAccountsTable = "CREATE TABLE IF NOT EXISTS Accounts (ACCOUNT_ID INT PRIMARY KEY NOT NULL,\n" +
            "ACCOUNT_NUMBER CHAR(20) NOT NULL UNIQUE,\n" +
            "OWNER CHAR(255) NOT NULL\n" +
            ");";
    private static final String INSERT_INTO_ACCOUNTS = "INSERT INTO ACCOUNTS (ACCOUNT_ID, ACCOUNT_NUMBER, OWNER) " +
            "VALUES(?, ?, ?)";

    private static final String GET_ALL_ACCOUNTS = "SELECT ACCOUNT_ID, ACCOUNT_NUMBER, OWNER FROM ACCOUNTS";
    private static final String SELECT_BY_ID =
            "SELECT ACCOUNT_ID, ACCOUNT_NUMBER, OWNER FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
    private static final String GET_ACCOUNT_ID = "SELECT ACCOUNT_ID FROM ACCOUNTS WHERE ACCOUNT_NUMBER =?";

    private static final String UPDATE_ACCOUNT =
            "UPDATE ACCOUNTS SET ACCOUNT_ID=?, ACCOUNT_NUMBER=?, OWNER FROM ACCOUNTS=? WHERE ACCOUNT_ID=?";

    private static final String DELETE_ACCOUNT = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
    private static final String CLEAR_ACCOUNTS = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID <10000";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS Accounts;";

    public DaoAccountImpl() {
    }

    @Override
    public void createAccountTable() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(createAccountsTable);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BankApiException("Can't create table Accounts in database");
        }
    }

    @Override
    public void addAccount(BankAccount account) {
        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(INSERT_INTO_ACCOUNTS);
            preStatement.setInt(1, account.getAccountId());
            preStatement.setString(2, account.getAccountNumber());
            preStatement.setString(3, account.getOwnersFullName());
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BankApiException("Can't addAccount " + account);
        }
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        List<BankAccount> accounts = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(GET_ALL_ACCOUNTS);

            while (result.next()) {

                BankAccount account = new BankAccount();
                account.setAccountId(result.getInt("ACCOUNT_ID"));
                account.setAccountNumber(result.getString("ACCOUNT_NUMBER"));
                account.setOwnersFullName(result.getString("OWNER"));

                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new BankApiException("Can't get all accounts ");
        }
        return accounts;
    }

    @Override
    public BankAccount getAccountById(int id) {
        BankAccount account = new BankAccount();

        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(SELECT_BY_ID);
            preStatement.setInt(1, id);
            ResultSet result = preStatement.executeQuery();

            account.setAccountId(result.getInt("ACCOUNT_ID"));
            account.setAccountNumber(result.getString("ACCOUNT_NUMBER"));
            account.setOwnersFullName(result.getString("OWNER"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BankApiException("Can't get account with id " + id);
        }
        return account;
    }

    @Override
    public int getAccountId(BankAccount account) {
        int id;
        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(GET_ACCOUNT_ID);
            preStatement.setString(1, account.getAccountNumber());
            ResultSet result = preStatement.executeQuery();

            id = result.getInt("ACCOUNT_ID");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BankApiException("Can't get account " + account);
        }
        return id;
    }

    @Override
    public void updateAccount(BankAccount account) {
        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(UPDATE_ACCOUNT);
            preStatement.setInt(1, account.getAccountId());
            preStatement.setString(2, account.getAccountNumber());
            preStatement.setString(3, account.getOwnersFullName());

            preStatement.executeUpdate();
        } catch (SQLException e) {
            throw new BankApiException("Can't update account " + account);
        }
    }

    @Override
    public void dropAccountTable() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(DROP_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BankApiException("Can't drop table Accounts from database");
        }
    }

    @Override
    public void removeAccount(BankAccount account) {
        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(DELETE_ACCOUNT);
            preStatement.setInt(1, account.getAccountId());

            preStatement.executeUpdate();
        } catch (SQLException e) {
            throw new BankApiException("Can't remove account " + account);
        }
    }

    @Override
    public void clearAccountTable() {
        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(CLEAR_ACCOUNTS);
            preStatement.executeUpdate();
        } catch (SQLException e) {
            throw new BankApiException("Can't clear Accounts");
        }
    }
}
