import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Item {
    private String name;
    private String description;
    private long minPrice;
    private List<Bid> allBids;
    private Bid highestBid;

    Item(String name, String description, long minPrice){
        this.name = Validator.checkParam(name);
        this.description = Validator.checkParam(description);
        this.minPrice = Validator.checkParam(minPrice);
        this.allBids = new ArrayList<>();
    }

    public void addBid(Person bidder, long price){
        Objects.requireNonNull(bidder);
        Validator.checkParam(price);

        if (this.isLessThanMaxPrice(price) || this.isLessThanMinPrice(price))
            return;
        Bid bid = new Bid(bidder, price);
        this.updateHighestBid(bid, price);
        allBids.add(bid);
    }

    public List<Bid> getAllBids(){
        return this.allBids;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    private void updateHighestBid(Bid bid, long price){
        if (highestBid == null || highestBid.getPrice() < price) {
            highestBid = bid;
        }
    }

    private boolean isLessThanMaxPrice(long price) {
        return highestBid != null && price <= highestBid.getPrice();
    }

    private boolean isLessThanMinPrice(long price) {
        return price < this.minPrice;
    }

    @Override
    public String toString() {
        return this.getName() + ": "
                + this.getDescription()
                +" (minimum bidding price: " + this.minPrice + " EUR)";
    }
}
