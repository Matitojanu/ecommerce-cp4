package pl.januszkiewicz.creditCard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.januszkiewicz.creditcard.CreditCantBeAssignedTwiceException;
import pl.januszkiewicz.creditcard.CreditCard;
import pl.januszkiewicz.creditcard.NotEnoughMoneyException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {

    private CreditCard card;

    @BeforeEach
    void setUp() {
        card = new CreditCard("1234-5678");
    }


    @Test
    void itAllowsToAssignCreditLimit() {
        card.assignCredit(BigDecimal.valueOf(1500));
        assertThrows(
                CreditCantBeAssignedTwiceException.class,
                () -> card.assignCredit(BigDecimal.valueOf(1500))
        );
    }

   @Test
    void iamAbleToWithdrawSomeMoney() {
        card.assignCredit(BigDecimal.valueOf(1500));

        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.withdraw(BigDecimal.valueOf(1600))
        );

   }
}