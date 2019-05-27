import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(1);
        l1.add(2);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>(l1);
        l2.add(3);
        System.out.println("Before = " + l2);
        l2.retainAll(l1);
        System.out.println("After  = " + l2);
        System.out.println("L1     = " + l1);
    }
}
