import java.util.ArrayList;

public class Taxi {
    private static final int MAX_PASSENGERS_AMOUNT = 4;
    private Human driver;
    private ArrayList<Human> passengers = new ArrayList<>();

    public Taxi(Human driver) { this.driver = driver; }

    public String getDriverName() {
        return driver.toString();
    }

    public Human[] allGetOut(){
        Human[] passengersArray = this.passengers.toArray(new Human[0]);
        this.passengers.clear();
        return passengersArray;
    }

    public void add(Human x) {
        if (this.passengers.size() < MAX_PASSENGERS_AMOUNT) {
            passengers.add(x);
            System.out.println(x.toString() + " gets in.");
        }
        else
            System.out.println("We are sorry, " + x.toString() + ". The taxi is full.");
    }

    @Override
    public String toString(){
        StringBuilder taxiInfo = new StringBuilder("This is the taxi of " + getDriverName() + ". He takes ");
        taxiInfo.append(getPassengers(this.passengers.size()));
        taxiInfo.append(" along.");
        return taxiInfo.toString();
    }

    private String getPassengers(int size) {
        StringBuilder passengers = new StringBuilder();
        switch (size){
            case 1:
                passengers.append(this.passengers.get(0).toString());
                break;
            case 2:
                passengers.append(this.passengers.get(0).toString()).append(" and ")
                        .append(this.passengers.get(1).toString());
                break;
            case 3:
                passengers.append(this.passengers.get(0).toString()).append(", ")
                        .append(this.passengers.get(1).toString()).append(" and ")
                        .append(this.passengers.get(2).toString());
                break;
            case 4:
                passengers.append(this.passengers.get(0).toString()).append(", ")
                        .append(this.passengers.get(1).toString()).append(", ")
                        .append(this.passengers.get(2).toString()).append(" and ")
                        .append(this.passengers.get(3).toString());
                break;
            default:
                passengers.append("nobody");
                break;
        }
        return passengers.toString();
    }

}
