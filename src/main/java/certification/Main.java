package certification;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String s = null;
        Optional<String> optionalS = Optional.ofNullable(s);
        Optional<String> optionalT = Optional.of(s);

    }
}
