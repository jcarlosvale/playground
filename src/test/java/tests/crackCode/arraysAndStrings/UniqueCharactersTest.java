package tests.crackCode.arraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueCharactersTest {

    @Test
    public void uniqueCharsTest() {
        assertTrue(UniqueCharacters.verify("abcd"));
        assertFalse(UniqueCharacters.verify("abcda"));
        String borderCase = Character.toString(Character.MAX_VALUE) + Character.toString(Character.MIN_VALUE);
        assertTrue(UniqueCharacters.verify(borderCase));
    }
}
