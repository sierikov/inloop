import java.util.LinkedHashMap;
import java.util.Map;

public class Leet {
    static Map<String, String> map = new LinkedHashMap<String, String>(){
            {
                put("elite", "1337");
                put("!", "!!!11");
                put("cool", "k3wl");
                put("ck", "xx");
                put("ers", "0rz");
                put("er", "0rz");
                put("en", "n");
                put("t", "7");
                put("e", "3");
                put("o", "0");
                put("a", "@");
            }};


    public static String toLeet(String normal){
        String result = normal;
        System.out.print(result);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            result = result.replaceAll(entry.getKey(), entry.getValue());
        }
        System.out.println(" -> " + result);

        return result;
    }

    public static String[] allToLeet(String[] org) {
        String res [] = new String[org.length];
        for( int i = 0; i < org.length; i++) res[i] = toLeet(org[i]);
        return res;
    }
}
