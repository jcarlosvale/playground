package tests.crackCode.arraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesTest {

    @Test
    public void removeDuplicatesTest() {
        assertEquals("abcd", RemoveDuplicates.removeDuplicates("abcd"));
        assertEquals("a", RemoveDuplicates.removeDuplicates("aaaa"));
        assertEquals(null, RemoveDuplicates.removeDuplicates(null));
        assertEquals("ab", RemoveDuplicates.removeDuplicates("ab"));
        assertEquals("ab", RemoveDuplicates.removeDuplicates("ab"));
        assertEquals("ab", RemoveDuplicates.removeDuplicates("ab"));
    }
}
