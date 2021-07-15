import java.util.Objects;

public class Validator {
    public static void checkParam(String... strings){
        for (String string : strings){
            checkParam(string);
        }
    }

    public static String checkParam(String string){
        Objects.requireNonNull(string);
        if(string.isEmpty()) throw new IllegalArgumentException();
        return string;
    }

    public static int checkParam(int i){
        if (i<0) throw new IllegalArgumentException();
        return i;
    }
}
