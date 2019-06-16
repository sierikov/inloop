import java.util.*;

public abstract class Stock {
    private Map<Part, Integer> parts;
    private List<StockObserver> observers;

    public Stock(){
        this.parts = new HashMap<>();
        this.observers = new ArrayList<>();
    }

    public int getCount(Part part){
        Objects.requireNonNull(part);
        return parts.getOrDefault(part, -1);
    }

    public boolean insert(Part part, int amount){
        Objects.requireNonNull(part);
        Validator.checkParam(amount);
        boolean isInParts = parts.containsKey(part);
        if (isInParts) {
            parts.replace(part, parts.get(part) + amount);
        } else parts.put(part, amount);
        return true;
    }

    public boolean remove(Part part, int count) {
        Objects.requireNonNull(part);
        Validator.checkParam(count);
        boolean isNotValid = !parts.containsKey(part) || count <= 0 || parts.get(part) < count;
        if (isNotValid) {
            return false;
        } else {
            parts.replace(part, parts.get(part) - count);
            this.notifyPartCountChanged(part);
            return true;
        }

    }

    public void addObserver(StockObserver observer) {
        Objects.requireNonNull(observer);
        observers.add(observer);
    }

    private void notifyPartCountChanged(Part part) {
        observers.forEach(observer -> observer.onPartCountChanged(part, parts.get(part)));
    }
}
