package certification;

public interface SomeInterface {
    default int someMethod() {
        return 0;
    }
}
