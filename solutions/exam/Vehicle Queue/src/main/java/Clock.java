import java.util.LinkedList;
import java.util.List;

public class Clock {
    private int currentTime = 0;
    private int endOfTime;
    private List<ClockObserver> observers;

    public Clock(int endOfTime){
        if (endOfTime < 0) {
            throw new IllegalArgumentException();
        } else {
            this.endOfTime = endOfTime;
            observers = new LinkedList<>();
        }
    }

    public void addObserver(ClockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ClockObserver observer) {
        observers.remove(observer);
    }

    public int getCurrentTime(){
        return this.currentTime;
    }

    public void tick(int currentTime) {
        for (ClockObserver vehicle : observers) {
            vehicle.tick(currentTime);
        }
    }

    public void run() {
        currentTime = 0;
        while (currentTime < endOfTime) {
            currentTime++;
            tick(currentTime);
        }
    }
}
