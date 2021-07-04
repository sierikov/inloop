import java.util.Objects;

public class Validator {

    public static Object checkParam(Object object){
        Objects.requireNonNull(object);
        return object;
    }

    static String checkParam(String str){
        Objects.requireNonNull(str);
        if (str.isEmpty()) throw new IllegalArgumentException();
        return str;
    }
}
