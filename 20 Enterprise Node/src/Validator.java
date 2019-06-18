import java.util.Objects;

public class Validator {
    public static String checkParam(String str){
        Objects.requireNonNull(str);
        if (str.isEmpty()) throw new IllegalArgumentException();
        return str;
    }
}
