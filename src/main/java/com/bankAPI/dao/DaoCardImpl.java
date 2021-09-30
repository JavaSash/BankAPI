package com.bankAPI.dao;

import com.bankAPI.exception.BankApiException;
import com.bankAPI.model.BankAccount;
import com.bankAPI.model.BankCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.bankAPI.util.ConnectionUtil.getConnection;


/**
 * Класс, реализующий взаимодействия с таблицей карт в БД
 */
public class DaoCardImpl implements DaoCard {
    private static final String createCardsTable = "CREATE TABLE IF NOT EXISTS Cards (CARD_ID SERIAL PRIMARY KEY NOT NULL,\n" +
            "CARD_NUMBER CHAR(16) NOT NULL UNIQUE,\n" +
            "ACCOUNT_ID INT REFERENCES Cards(ACCOUNT_ID) ON DELETE CASCADE ON UPDATE CASCADE\n" +
            ");";

    private static final String INSERT_INTO_CADRS = "INSERT INTO Cards (CARD_ID, CARD_NUMBER, ACCOUNT_ID) " +
            "VALUES(?, ?, ?)";

    private static final String GET_ALL_CARDS =
            "SELECT CARD_ID, CARD_NUMBER, ACCOUNT_ID FROM CARDS";
    private static final String SELECT_BY_ID =
            "SELECT CARD_ID, CARD_NUMBER, ACCOUNT_ID FROM CARDS WHERE CARD_ID = ?";

    private static final String UPDATE_CARD =
            "UPDATE CARDS SET CARD_ID=?, CARD_NUMBER=?, ACCOUNT_ID FROM CARDS=? WHERE CARD_ID=?";

    private static final String DELETE_CARD = "DELETE FROM CARDS WHERE CARD_ID = ?";
    private static final String CLEAR_CARDS = "DELETE FROM Cards WHERE CARD_ID <10000";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS Cards;";

    @Override
    public void createCardsTable() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(createCardsTable);
        } catch (SQLException e) {
            throw new BankApiException("Can't create Cards table in database");
        }
    }

    @Override
    public void addCard(BankCard card) {
        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(INSERT_INTO_CADRS);
            preStatement.setInt(1, card.getCardId());
            preStatement.setString(2, card.getCardNumber());
            preStatement.setInt(3, card.getAccountId());

            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BankApiException("Can't add card " + card);
        }
    }

    @Override
    public List<BankCard> getAllCards(int id) {
        List<BankCard> cards = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            PreparedStatement preStatement = connection.prepareStatement(GET_ALL_CARDS);
            ResultSet result = statement.executeQuery(GET_ALL_CARDS);
//            ResultSet result = preStatement.executeQuery(GET_ALL_CARDS);

            while (result.next()) {
                BankAccount account = new DaoAccountImpl().getAccountById(id);
                BankCard card = account.issueCard();
                card.setCardId(result.getInt("CARD_ID"));
                card.setCardNumber(result.getString("CARD_NUMBER"));
                card.setAccountId(result.getInt("ACCOUNT_ID"));

                cards.add(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BankApiException("Can't get all cards by account id " + id);
        }
        return cards;
    }

    @Override
    public BankCard getCardById(int id) {
        BankCard card = new BankAccount().issueCard();

        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(SELECT_BY_ID);
            preStatement.setInt(1, id);
            ResultSet result = preStatement.executeQuery();

            card.setCardId(result.getInt("CARD_ID"));
            card.setCardNumber(result.getString("CARD_NUMBER"));
            card.setAccountId(result.getInt("ACCOUNT_ID"));
        } catch (SQLException e) {
            throw new BankApiException("Can't get card with id " + id);
        }
        return card;
    }

    @Override
    public void updateCard(BankCard card) {
        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(UPDATE_CARD);
            preStatement.setInt(1, card.getCardId());
            preStatement.setString(2, card.getCardNumber());
            preStatement.setInt(3, card.getAccountId());

            preStatement.executeUpdate();
        } catch (SQLException e) {
            throw new BankApiException("Can't update " + card);
        }
    }

    @Override
    public void dropCardsTable() {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(DROP_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BankApiException("Can't drop table Cards from database");
        }
    }

    @Override
    public void removeCard(BankCard card) {
        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(DELETE_CARD);
            preStatement.setInt(1, card.getCardId());

            preStatement.executeUpdate();
        } catch (SQLException e) {
            throw new BankApiException("Can't remove card " + card);
        }
    }

    @Override
    public void clearCardsTable() {
        try (Connection connection = getConnection()) {
            PreparedStatement preStatement = connection.prepareStatement(CLEAR_CARDS);
            preStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new BankApiException("Can't clear Cards");
        }
    }
}
