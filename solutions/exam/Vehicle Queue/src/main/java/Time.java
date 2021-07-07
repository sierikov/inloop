import java.util.Observable;

public class Time extends Observable {
    private static Time instance;
    private int currentTime = 0;
    private int endofTime = 100;

    private Time(){ }

    public static Time getInstance(){
        return instance;
    }

    public int getCurrentTime(){
        return this.currentTime;
    }

    public void initEndOfTime(int seconds){
        if (seconds < 0) throw new IllegalArgumentException();
        this.currentTime = 0;
        this.endofTime = seconds;
    }

    public void run(){
        for (int i = 0; i < this.endofTime; ++i) {
            this.currentTime++;
            this.setChanged();
            this.notifyObservers(currentTime);
        }
    }
}
