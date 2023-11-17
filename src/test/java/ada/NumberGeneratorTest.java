package ada;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NumberGeneratorTest {

    @Test
    public void testGenerateNumbers() {
        NumberGenerator generator = new NumberGenerator();
        List<Integer> resultList = generator.generateNumbers();

        for (int expected = 1; expected <= 100; expected++) {
            int actual = resultList.get(expected-1);
            assertEquals(expected, actual);
        }
    }

}