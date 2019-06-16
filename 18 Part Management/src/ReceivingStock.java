public class ReceivingStock extends Stock {
    private int minStockItems;
    private int maxStockItems;
    public ReceivingStock(int minStockItems, int maxStockItems) {
        if (maxStockItems <= minStockItems) throw new IllegalArgumentException();
        this.maxStockItems = Validator.checkParam(maxStockItems);
        this.minStockItems = Validator.checkParam(minStockItems);
    }

    public int getMinStockItems() {
        return this.minStockItems;
    }

    public int getMaxStockItems() {
        return this.maxStockItems;
    }

    @Override
    public boolean insert(Part part, int amount) {
        if ( amount > this.maxStockItems) return false;
        return super.insert(part, amount);
    }

    @Override
    public boolean remove(Part part, int amount){
        Validator.checkParam(amount);
        if (amount < 0) return false;
        return super.remove(part, amount);

    }
}
