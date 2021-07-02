import java.util.Objects;

public class Purchasing implements StockObserver {
    private ReceivingStock receivingStock;

    public Purchasing(ReceivingStock receivingStock) {
        this.receivingStock = Objects.requireNonNull(receivingStock);
    }

    public void buy(Part part, int count) {
        receivingStock.insert(part, count);
    }

    public ReceivingStock getStock() {
        return this.receivingStock;
    }

    @Override
    public void onPartCountChanged(Part part, int count) {
        int newAmount = this.receivingStock.getMaxStockItems() - count;
        this.buy(part, newAmount);
    }
}
