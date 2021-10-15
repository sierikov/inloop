public class Main {

    public static void main(String[] args) {
        Human driver = new Human("Juergen","Staub");

        Human m1 = new Human("Andrea", "Bora");
        Human m2 = new Human("Franzi","Ada");
        Human m3 = new Human("Leah","Posh");
        Human m4 = new Human("Susi","Fresh");
        Human m5 = new Human("Lucky","Fuke");

        Taxi aTaxi = new Taxi(driver);

        aTaxi.add(m1);
        aTaxi.add(m2);
        aTaxi.add(m3);
        aTaxi.add(m4);
        aTaxi.add(m5);

        aTaxi.allGetOut();

        System.out.println(aTaxi);

    }
}
