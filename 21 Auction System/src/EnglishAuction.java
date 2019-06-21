import java.util.Objects;

public class EnglishAuction extends Auction {
    @Override
    public String generateItemString(Item item) {
        Objects.requireNonNull(item);
        StringBuilder builder = new StringBuilder();
        builder.append(item);
        if(item.getAllBids().isEmpty())
            builder.append("\nNo bids placed");
        else
            builder
                    .append("\nHighest bid: ")
                    .append(item.getHighestBid().toString());
        return builder.toString() ;
    }
}
