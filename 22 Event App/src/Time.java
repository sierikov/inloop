public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute){
        this.hour = Validator.checkHours(hour);
        this.minute = Validator.checkMinutes(minute);
    }
    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }
}