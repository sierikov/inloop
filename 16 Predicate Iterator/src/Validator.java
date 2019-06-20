import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.Objects;

public class Validator {
    public static boolean checkParams(String... strings) {
        boolean isValid;
        for ( String string : strings ) {
            isValid = checkParam(string);
            if (!isValid) return false;
        }
        return true;
    }

    private static boolean checkParam(String string) {

        return string != null && string.isEmpty();
    }


}
