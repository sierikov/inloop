import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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

    public void addBid(Item item, String nameOfBidder, long price) {
        this.checkClosed();
        Validator.checkParam(item);
        Validator.checkParam(price);
        Person bidder = this.findBidderOrNew(nameOfBidder);
        this.findItem(item);
        if (!bidders.contains(bidder)) {
            bidders.add(bidder);
        }
        item.addBid(bidder, price);
    }

    private Item findItem(Item item) {
        return allItems
                .stream()
                .filter(item1 -> item1.equals(item))
                .findAny().orElseThrow(() -> new NoSuchElementException("There is no bid with this name"));
    }


    private Person findBidderOrNew(String name){
        return bidders.stream()
                .filter(person -> person.getName().equals(name))
                .findAny()
                .orElse(new Person(name));
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