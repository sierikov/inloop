import java.util.Random;

public class VehicleGenerator {
    private Random randomGenerator;

    VehicleGenerator(){
        randomGenerator = new Random();
    }

    public  Vehicle createVehicle(){
        int vehicleType = randomGenerator.nextInt(3);
        switch (vehicleType) {
            case 1: return new Bicycle();
            case 2: return new Bus();
            default: return new Car();
        }
    }
}
