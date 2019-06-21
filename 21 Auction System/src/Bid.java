import java.util.Objects;

public class Bid {

    private Person bidder;
    private long price;

    Bid(Person bidder, long price){
        this.bidder = Objects.requireNonNull(bidder);
        this.price = Validator.checkParam(price);
    }

    public Person getBidder() {
        return bidder;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.price + " EUR by " + this.bidder;
    }
}
