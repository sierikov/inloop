import java.util.Map;
import java.util.Objects;

class Validator {
    static String checkParam(String string) {
        if(Objects.isNull(string)) throw new NullPointerException();
        if(string.isEmpty()) throw  new IllegalArgumentException();
        return string;
    }

    static double checkParam(double d) {
        if(d <= 0) throw new IllegalArgumentException();
        return d;
    }

    static int checkParam(int i) {
        if(i <= 0) throw new IllegalArgumentException();
        return i;
    }

    static void checkParam(Map<String, Integer> mapToCheck){
        Objects.requireNonNull(mapToCheck);

        for (Map.Entry<String, Integer> entry : mapToCheck.entrySet()) {
            if (entry.getKey() == null) throw new NullPointerException();
            if (entry.getValue() == null) throw new NullPointerException();
        }
    }

}
