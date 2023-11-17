package ada;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BankCalendarSecretTest {

    @Test
    public void testeCaso100Chamadas() {
        // given
        BankCalendar myCalendar = new BankCalendar();

        // Executar 100 chamadas
        for (int i = 0; i < 100; i++) {
            int start = i * 2;
            int end = start + 10;

            // A cada 5 chamadas temos uma bem sucedida
            boolean expectedResult = (i % 5 == 0);
            boolean actualResult = myCalendar.book(start, end);

            // Verificar se o resultado esperado é igual ao resultado real
            assertEquals(expectedResult, actualResult);
        }
    }

    @Test
    public void testeCasoComplexo() {
        // given
        BankCalendar myCalendar = new BankCalendar();

        assertTrue(myCalendar.book(10, 20));  // Reserva 1 (sucesso)
        assertFalse(myCalendar.book(15, 25)); // Tentativa de sobreposição (falha)
        assertTrue(myCalendar.book(20, 30));  // Reserva 2 (sucesso)
        assertFalse(myCalendar.book(5, 15));  // Tentativa de sobreposição (falha)
        assertFalse(myCalendar.book(25, 35)); // Reserva 3 (falha)
        assertFalse(myCalendar.book(10, 30)); // Tentativa de sobreposição (falha)
        assertTrue(myCalendar.book(40, 50)); // Reserva 4 (sucesso)
        assertFalse(myCalendar.book(35, 45)); // Tentativa de sobreposição (falha)
        assertTrue(myCalendar.book(5, 10));   // Reserva 5 (sucesso)
        assertFalse(myCalendar.book(2, 8));   // Tentativa de sobreposição (falha)
        assertTrue(myCalendar.book(55, 65)); // Reserva 6 (sucesso)
        assertFalse(myCalendar.book(60, 70)); // Tentativa de sobreposição (falha)
    }
}