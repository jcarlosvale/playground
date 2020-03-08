package tests.bolt;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsTest {

    @Test
    public void reverseOK() {
        char[] actual =
                ReverseWords.reverseWords(new char[]{'I', ' ', 'l', 'o', 'v', 'e', ' ', 'T', 'a', 'x', 'i', 'f', 'y'});
        char[] expected = new char[]{'I', ' ', 'e','v','o','l',' ','y','f','i','x','a','T'};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseNull() {
        char[] actual =
                ReverseWords.reverseWords(null);
        char[] expected = null;
        assertEquals(expected, actual);
    }


    @Test
    public void reverse2() {
        char[] actual =
                ReverseWords.reverseWords(new char[]{' ', ' ', 'l', 'o', 'v', 'e', ' ', ' ', ' ', ' ', ' ', ' ', ' '});
        char[] expected = new char[]{' ', ' ', 'e','v','o','l',' ',' ',' ',' ',' ',' ',' '};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseOK3() {
        char[] actual =
                ReverseWords.reverseWords(new char[]{'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '});
        char[] expected = new char[]{'I', ' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' '};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverseOK4() {
        char[] actual =
                ReverseWords.reverseWords(new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', 'T', 'a', 'x', 'i', 'f', 'y'});
        char[] expected = new char[]{' ', ' ', ' ',' ',' ',' ',' ','y','f','i','x','a','T'};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void reverse5() {
        char[] actual =
                ReverseWords.reverseWords(new char[]{'l', 'o', 'v', 'e'});
        char[] expected = new char[]{'e','v','o','l'};
        assertArrayEquals(expected, actual);
    }

}
