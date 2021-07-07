import java.util.Objects;

public class Validator {
    public static void checkParam(Object o){
        Objects.requireNonNull(o);
    }

    public static String checkParam(String str){
        Objects.requireNonNull(str);
        if (str.isEmpty()) throw new IllegalArgumentException();
        return str;
    }

    public static long checkParam(long l) {
        if (l <= 0) throw new IllegalArgumentException();
        return l;
    }
}
