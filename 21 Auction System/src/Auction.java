import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Auction {
    private boolean closed;
    private List<Person> bidders;
    private List<Item> allItems;

    Auction() {
        closed = false;
        bidders = new ArrayList<>();
        allItems = new ArrayList<>();
    }

    public void addBid(String itemName, String nameOfBidder, long price) {
        Validator.checkParam(itemName);
        Validator.checkParam(price);
        Person bidder = this.findBidderOrNew(nameOfBidder);
        Item item = this.findItem(itemName);
        if (!bidders.contains(bidder)) {
            bidders.add(bidder);
        }
        item.addBid(bidder, price);
    }

    private Item findItem(String itemName) {
        return allItems
                .stream()
                .filter(item1 -> item1.getName().equals(itemName))
                .findAny().get();
    }


    private Person findBidderOrNew(String name){
        return bidders.stream()
                .filter(person -> person.getName().equals(name))
                .findAny()
                .orElse(new Person(name));
    }

    // because in the test is int (UML - long)
    void addBid(String itemName, String nameOfBidder, int price) {
        this.checkClosed();
        this.addBid(itemName, nameOfBidder, Long.valueOf(price));
    }

    void registerItem(Item item) {
        Objects.requireNonNull(item);
        this.checkClosed();
        if (this.exist(item)) {
            throw new IllegalArgumentException("This item is already in the auction!");
        }
        allItems.add(item);
    }

    private boolean exist(Item item) {
        return allItems
                .stream()
                .anyMatch(
                        item1 -> item.getName().equals(item1.getName())
                );
    }

    private void checkClosed(){
        if (this.closed) throw new IllegalStateException();
    }

    String closeAuction() {
        this.checkClosed();
        this.closed = true;
        return this.generateItemListString();
    }

    List<Item> getAllItems() {
        return allItems;
    }

    String generateItemListString() {
        StringBuilder builder = new StringBuilder();
        this.allItems.forEach(item -> builder.append(generateItemString(item)).append("\n"));
        return builder.toString();
    }

    String generateAllBidsString(Item item) {
        StringBuilder builder = new StringBuilder();
        builder.append("All bids:");
        item.getAllBids().forEach(bid -> builder.append("\n").append(bid.toString()));
        return builder.toString();
    }

    public abstract String generateItemString(Item item);
}