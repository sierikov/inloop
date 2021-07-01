import java.util.Objects;

public class Validator {
    public static String checkParam(String string){
        Objects.requireNonNull(string);
        if(string.isEmpty()) throw new IllegalArgumentException();
        return string;
    }

    public static double checkParam(double d){
        if (d <= 0d) throw new IllegalArgumentException();
        return d;
    }

    public static long checkParam(long l){
        if (l < 0) throw new IllegalArgumentException();
        return l;
    }
}
