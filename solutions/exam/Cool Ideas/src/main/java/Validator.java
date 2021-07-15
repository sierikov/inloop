import java.util.Objects;

public class Validator {
    public static void checkParam(JContent... os) {
        for (Object o : os) {
            Objects.requireNonNull(o);
        }
    }

    public static ContentObserver checkParam(ContentObserver co) {
        return Objects.requireNonNull(co);
    }

    public static String checkParam(String string) {
        Objects.requireNonNull(string);
        if (string.isEmpty()) throw new IllegalArgumentException();
        return string;
    }

    public static int checkParam(int i) {
        if (i < 0) throw new IllegalArgumentException();
        return i;
    }
}
