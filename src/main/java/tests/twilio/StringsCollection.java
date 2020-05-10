package tests.twilio;

import java.util.ArrayList;
import java.util.List;

public class StringsCollection {
    private final List<String> stringsCollection;

    public StringsCollection() {
        this.stringsCollection = new ArrayList<>();
    }

    public synchronized void addString(String string) {
        stringsCollection.add(string);
    }

    public synchronized List<String> getStringsCollection() {
        return stringsCollection;
    }
}
