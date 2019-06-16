import java.util.Objects;

public class Validator {
    public static String checkParam(String str){
        Objects.requireNonNull(str);
        if (str.isEmpty()) throw new IllegalArgumentException();
        return str;
    }

    public static int checkParam(int i){
        if (i < 1) throw new IllegalArgumentException();
        return i;
    }

    public static void checkParam(String... strings) {
        for(String string : strings){
            checkParam(string);
        }
    }
}
