import java.util.Objects;

public class AllPayAuction extends Auction {
    @Override
    public String generateItemString(Item item) {
        StringBuilder sb = new StringBuilder();
        sb.append(item.toString()).append("\n");
        if (item.getAllBids().size() != 0) {
            sb.append("Highest bid: ")
                    .append(item.getHighestBid().toString())
                    .append("\n");
            sb.append(generateAllBidsString(item));
        } else {
            sb.append("No bids placed");
        }
        return sb.toString();
    }
}
