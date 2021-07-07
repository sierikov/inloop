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

    private int getPhaseTime(){ return  this.getPhaseTime(this.iTime); }

    private int getPhaseTime(int currentTime){
        return currentTime % (trafficLightRate * 2);
    }

    public double getLength() {
        return queue.stream()
                .map(Vehicle::getLength)
                .reduce(0.0, Double::sum);
    }

    private Integer getTime(){ return this.iTime; }

    private double getLastLeave() {
        return Math.round(this.exitDelay * needToLeaveAmount(this.getTime() - 1));
    }

    private void setTime(Object timeObject) { this.iTime = (Integer) timeObject; }

    private void switchLight() {
        if (this.getPhaseTime() % this.trafficLightRate == 0)
            this.greenLight = !this.greenLight;
    }
    private boolean isSwitched(int time) {
        boolean isChangedFromLastTime = !isGreenLight(time) && isGreenLight(time - 1);
        return time != 0 && (isChangedFromLastTime);
    }
    private boolean isGreenLight(int time) {
        return this.getPhaseTime(time) >= trafficLightRate;
    }

    @Override
    public void update(Observable observable, Object timeObject) {
        this.setTime(timeObject);

        this.switchLight();

        double toEnter = amountToEnter();
        for (int i = 0; i < toEnter; i++) this.enter();

        double toLeave = amountToLeave();
        for (int i = 0; i < toLeave; i++) this.leave();

    }

    private double amountToEnter() {
        int time = this.getTime();
        return needToEnterAmount(time) - needToEnterAmount(time - 1);
    }

    private double amountToLeave() {
        int timeInt = this.getTime();
        int phaseTime = this.getPhaseTime();
        if (isSwitched(timeInt))
            return Math.floor((this.trafficLightRate - this.getLastLeave()) / this.exitDelay);
        else
            return needToLeaveAmount(phaseTime) - needToLeaveAmount(phaseTime - 1);
    }

    private double needToEnterAmount(double currentTime) { return Math.floor(currentTime / this.entryDelay); }

    private double needToLeaveAmount(double currentTime) {
        if (currentTime < this.trafficLightRate) return 0d;
        currentTime %= this.trafficLightRate;
        return Math.floor(currentTime / this.exitDelay);
    }

}
