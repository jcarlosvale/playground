package ada;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BankCalendarTest {

    @Test
    public void testeCasoUm() {
        // given
        BankCalendar myCalendar = new BankCalendar();

        assertTrue(myCalendar.book(10, 20));
        assertFalse(myCalendar.book(15, 25));
        assertTrue(myCalendar.book(20, 30));
    }

    @Test
    public void testeCasoDois() {
        // given
        BankCalendar myCalendar = new BankCalendar();

        assertTrue(myCalendar.book(5, 15));
        assertTrue(myCalendar.book(25, 35));
        assertFalse(myCalendar.book(10, 30));
    }

    @Test
    public void testeCasoTres() {
        // given
        BankCalendar myCalendar = new BankCalendar();

        assertTrue(myCalendar.book(10, 20));
        assertFalse(myCalendar.book(15, 25));
        assertFalse(myCalendar.book(5, 15));
        assertTrue(myCalendar.book(25, 35));
    }
}