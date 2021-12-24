package tests.klarna;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditCardTest {

    @Test
    public void shouldMaskDigitsForBasicCreditCards() {
        assertEquals("5###########0694", CreditCard.maskify("5512103073210694"));
    }

    @Test
    public void shouldNotMaskDigitsForShortCreditCards() {
        assertEquals("54321", CreditCard.maskify("54321"));
    }
}