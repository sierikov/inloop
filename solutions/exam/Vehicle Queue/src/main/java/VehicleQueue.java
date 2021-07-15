import java.util.*;

public class VehicleQueue implements ClockObserver {
    private final Queue<Vehicle> queue = new LinkedList<>();

    private int currentTime;

    private final double entryDelay;
    private final double exitDelay;

    private boolean greenLight = false;

    private final int trafficLightRate;

    private final VehicleGenerator generator;

    public VehicleQueue(double entryDelay, double exitDelay, int trafficLightRate, VehicleGenerator generator) {
        Objects.requireNonNull(generator);
        if (trafficLightRate <= 0 || entryDelay <= 0d || exitDelay <= 0d) throw new IllegalArgumentException();
        this.exitDelay = exitDelay;
        this.entryDelay = entryDelay;
        this.generator = generator;
        this.trafficLightRate = trafficLightRate;
    }

    /**
     * Gets the new {@code Vehicle} from {@code VehicleGenerator} and
     * adds it to the {@code queue}
     */
    public void enter() {
        queue.add(generator.createVehicle());
    }

    /**
     * Removes the {@code Vehicle} from the {@code queue}
     */
    public void leave() {
        queue.poll();
    }

    /**
     * Gets the amount of {@code Vehicle} that are inside the {@code queue}
     */
    public int getSize() {
        return queue.size();
    }

    /**
     * Gets the reminder time before {@code greenLight} changes.
     */
    private int getDuration(){
        return  this.remainTimeToChangeLights(this.currentTime);
    }

    /**
     * Calculate the remain time to change the {@code greenLight}.
     */
    private int remainTimeToChangeLights(int currentTime){
        return currentTime % (trafficLightRate * 2);
    }
    private Integer getTime(){
        return this.currentTime; }


    public double getLength() {
        return queue.stream()
                .map(Vehicle::getLength)
                .reduce(0.0, Double::sum);
    }


    private double getLastLeave() {
        return Math.round(this.exitDelay * needToLeaveAmount(this.getTime() - 1));
    }

    private void setTime(int currentTime) {
        this.currentTime = currentTime; }

    private void switchLight() {
        if (this.getDuration() % this.trafficLightRate == 0)
            this.greenLight = !this.greenLight;
    }
    private boolean isSwitched(int time) {
        boolean isChangedFromLastTime = !isGreenLight(time) && isGreenLight(time - 1);
        return time != 0 && (isChangedFromLastTime);
    }
    private boolean isGreenLight(int time) {
        return this.remainTimeToChangeLights(time) >= trafficLightRate;
    }


    private double amountToEnter() {
        int time = this.getTime();
        return needToEnterAmount(time) - needToEnterAmount(time - 1);
    }

    private double amountToLeave() {
        int timeInt = this.getTime();
        int phaseTime = this.getDuration();
        if (isSwitched(timeInt))
            return Math.floor((this.trafficLightRate - this.getLastLeave()) / this.exitDelay);
        else
            return needToLeaveAmount(phaseTime) - needToLeaveAmount(phaseTime - 1);
    }

    private double needToEnterAmount(double currentTime) {
        return Math.floor(currentTime / this.entryDelay); }

    private double needToLeaveAmount(double currentTime) {
        if (currentTime < this.trafficLightRate) return 0d;
        currentTime %= this.trafficLightRate;
        return Math.floor(currentTime / this.exitDelay);
    }

    @Override
    public void tick(int currentTime) {
        this.setTime(currentTime);
        this.switchLight();

        double toEnter = amountToEnter();
        for (int i = 0; i < toEnter; i++) this.enter();

        double toLeave = amountToLeave();
        for (int i = 0; i < toLeave; i++) this.leave();
    }
}
