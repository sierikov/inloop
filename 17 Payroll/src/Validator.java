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

    public static int checkParam(int i){
        if (i <= 0) throw new IllegalArgumentException();
        return i;
    }

    public static int checkDayInMonth(int day){
        if (day <= 0 || day > 31) throw new IllegalArgumentException();
        return day;
    }
}
