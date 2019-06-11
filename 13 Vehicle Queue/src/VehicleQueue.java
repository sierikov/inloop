import java.util.*;

public class VehicleQueue implements Observer {
    private final Queue<Vehicle> queue = new LinkedList<>();

    private Integer iTime;
    private double entryDelay;
    private double exitDelay;

    private boolean greenLight = false;
    private int trafficLightRate;

    private VehicleGenerator generator;

    public VehicleQueue(double entryDelay, double exitDelay, int trafficLightRate, VehicleGenerator generator) {
        Objects.requireNonNull(generator);
        if (trafficLightRate <= 0 || entryDelay <= 0d || exitDelay <= 0d) throw new IllegalArgumentException();
        this.exitDelay = exitDelay;
        this.entryDelay = entryDelay;
        this.generator = generator;
        this.trafficLightRate = trafficLightRate;
    }

    public void enter() {
        queue.add(generator.createVehicle());
    }

    public void leave() {
        queue.poll();
    }

    public int getSize() {
        return queue.size();
    }

    public double getLength() {
        return queue.stream()
                .map(Vehicle::getLength)
                .reduce(0.0, Double::sum);
    }

    private boolean isGreenLight(int time) { return this.getPhaseTime(time) >= trafficLightRate; }

    private boolean isSwitched(int time) { return time != 0 && (!isGreenLight(time) && isGreenLight(time - 1)); }

    private void switchLight() {
        if (this.getPhaseTime() % trafficLightRate == 0)
            greenLight = !greenLight;
    }

    private int getPhaseTime(){ return  this.getPhaseTime(this.iTime); }
    private int getPhaseTime(int time){ return time % (trafficLightRate * 2); }

    @Override
    public void update(Observable observable, Object timeObject) {
        this.setTime(timeObject);

        this.switchLight();

        double toEnter = amountToEnter();
        for (int i = 0; i < toEnter; i++) this.enter();

        double toLeave = amountToLeave();
        for (int i = 0; i < toLeave; i++) this.leave();

    }

    private void setTime(Object timeObject) { this.iTime = (Integer) timeObject; }
    private Integer getTime(){ return this.iTime; }

    private double amountToEnter() {
        int time = this.getTime();
        return vehiclesToEnterAbsolute(time) - vehiclesToEnterAbsolute(time - 1);
    }

    private double vehiclesToEnterAbsolute(double second) { return Math.floor(second / entryDelay); }

    private double vehiclesToLeaveAbsolute(double time) {
        if (time < trafficLightRate) return 0.0;
        time %= trafficLightRate;
        return Math.floor(time / exitDelay);
    }

    private double amountToLeave() {
        int timeInt = this.getTime();
        int phaseTime = this.getPhaseTime();
        if (isSwitched(timeInt)) {
            double lastExit = Math.round(exitDelay * vehiclesToLeaveAbsolute(timeInt - 1));
            return Math.floor((trafficLightRate - lastExit) / exitDelay);
        } else return vehiclesToLeaveAbsolute(phaseTime) - vehiclesToLeaveAbsolute(phaseTime - 1);
    }

}
