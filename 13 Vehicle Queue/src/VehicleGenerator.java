import java.util.Random;

public class VehicleGenerator {
    private Random randomGenerator;

    VehicleGenerator(){
        randomGenerator = new Random();

    }

    public  Vehicle createVehicle(){
        int type = randomGenerator.nextInt(3);

        switch (type) {
            case 1: return new Bicycle();
            case 2: return new Bus();
            default: return new Car();
        }
    }
}
