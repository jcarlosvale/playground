package tests.crackCode.arraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest {

    @Test
    public void reverseTest() {
        assertEquals("abc", ReverseString.reverse("cba"));
        assertEquals("some test", ReverseString.reverse("tset emos"));
    }

}
