import java.util.Objects;
import java.util.Set;

public class Validator {
    static int checkMinutes(int i){
        if(i < 0 || i > 59)throw new IllegalArgumentException();
        return i;
    }

    static int checkHours(int i){
        if(i < 0 || i > 23) throw new IllegalArgumentException();
        return i;
    }

    static String checkParam(String str){
        Objects.requireNonNull(str);
        if(str.isEmpty()) throw new IllegalArgumentException();
        return str;
    }

    public static void checkParam(Set<Time> timeSet) {
        Objects.requireNonNull(timeSet);
        if(timeSet.stream().anyMatch(Objects::isNull)) throw new NullPointerException();
    }
}
