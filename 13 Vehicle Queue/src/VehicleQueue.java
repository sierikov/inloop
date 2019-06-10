import java.util.LinkedList;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class VehicleQueue implements Observer {
    private double entryDelay;
    private double exitDelay;
    private int trafficLightRate;
    private boolean greenLight = false;
    private VehicleGenerator generator;
    private LinkedList<Vehicle> queue = new LinkedList<>();

    VehicleQueue(double entryDelay, double exitDelay, int trafficLightRate, VehicleGenerator generator) {
        Objects.requireNonNull(generator);
        if (trafficLightRate <= 0 || entryDelay <= 0 || exitDelay <= 0)
            throw new IllegalArgumentException("");

        this.generator = generator;
        this.exitDelay = exitDelay;
        this.entryDelay = entryDelay;
        this.trafficLightRate = trafficLightRate;
    }

    public void enter() {
        Vehicle ve = generator.createVehicle();
        queue.add(ve);
    }

    public void leave() {
        if (!queue.isEmpty()) queue.removeFirst();
    }

    public double getLength() {
        double length = 0;
        for (Vehicle v : queue) {
            length = length + v.getLength();
        }
        return length;
    }


    public int getSize() {
        return queue.size();
    }

    @Override
    public void update(Observable o, Object curT) {
        int currentTime = (int) curT;
        this.greenLight = this.checkGreenLight(currentTime);
        if (currentTime == 1) {
            entryDelay = 1;
        }

        for (int i = 0; i < Math.floor(entryDelay / entryDelay); i++) {
            this.enter();
        }
        for (int i = 0; i < Math.floor(entryDelay / exitDelay); i++) {
            this.leave();
        }
        entryDelay = entryDelay % exitDelay;
        entryDelay++;
        if (greenLight) {
            exitDelay++;
        } else {
            exitDelay = 0;
        }
    }

    private boolean checkGreenLight(int currentTime) {
        double greenCycle = 2 * this.trafficLightRate;
        double currentCycle = currentTime % greenCycle;
        return currentCycle >= trafficLightRate;
    }
}
