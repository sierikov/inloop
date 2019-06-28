public class Simulation {
    public static void main(String[] args) {
        Time time = Time.getInstance();
        VehicleQueue queue = new VehicleQueue(0.1, 0.5, 30, new VehicleGenerator());

        time.addObserver(queue);
        time.initEndOfTime(70);
        time.run();

        System.out.println("Number of vehicles at the end of time: " + queue.getSize());
        System.out.println("Length of the queue at the end of time: " + queue.getLength());
    }
}
