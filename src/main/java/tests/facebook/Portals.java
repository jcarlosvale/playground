package tests.facebook;

import java.util.Arrays;
import java.util.Locale;

class Portals {

    public int getSecondsRequired(int R, int C, char[][] G) {
        // Write your code here
        return 0;
    }

    public static String normaliseName(final String name) {

        final String [] normalisedNameArray = name.split(" ");
        final StringBuilder normalisedName = new StringBuilder();

        for (int i = 0; i < normalisedNameArray.length - 1; i++) {
            final String partOfName = normalisedNameArray[i].toUpperCase().charAt(0) + ". ";
            normalisedName.append(partOfName);
        }

        //last surname
        String surname = normalisedNameArray[normalisedNameArray.length-1].toLowerCase();
        surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        normalisedName.append(surname);

        System.out.println(normalisedName);

        return normalisedName.toString();
    }

    public static void main(String[] args) {
        System.out.println(normaliseName("john aaron smith"));
    }
}