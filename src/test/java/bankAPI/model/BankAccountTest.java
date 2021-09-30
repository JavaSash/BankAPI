package bankAPI.model;

import com.bankAPI.exception.BankApiException;
import com.bankAPI.model.BankAccount;
import com.bankAPI.model.BankCard;
import com.bankAPI.model.Client;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankAccountTest {
    private static final String FULL_NAME = "Валерий Деревянко";
    private static final long amountLong = 10L;
    private static final float amountFloatLessZero = -1.0f;
    private static final float amountPositive = 10.24f;
    Client client = new Client(FULL_NAME);
    BankAccount account = client.getAccount();
    List<BankCard> cards = account.getAllCards();

    @Test
    public void issueCard() {
        BankCard card1 = client.getAccount().issueCard();
        BankCard card2 = client.getAccount().issueCard();
        BankCard card3 = client.getAccount().issueCard();
        assertEquals(3, cards.size());
        assertTrue(cards.contains(card1));
        assertTrue(cards.contains(card2));
        assertTrue(cards.contains(card3));
    }

    @Test
    public void getAllCards() {
    }
//TODO why 10.0 not equals 10.0?
    @Test
    public void depositLong() {
        float startBalance = account.getBalance();
        account.deposit(amountLong);
        assertEquals(new BigDecimal(startBalance), new BigDecimal(account.getBalance() - amountLong));
    }

    @Test
    public void depositFloat() {

    }

    @Test(expected = BankApiException.class)
    public void depositLessZero() {
        account.deposit(amountFloatLessZero);
    }

    @Test
    public void getBalance() {
        assertEquals(0.f, account.getBalance(), 2);
        account.deposit(amountPositive);
        assertEquals(amountPositive, account.getBalance(), 2);

    }
}