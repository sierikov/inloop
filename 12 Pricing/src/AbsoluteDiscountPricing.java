public class AbsoluteDiscountPricing implements ISalePricing {
    private long threshold;
    private long discount;

    public AbsoluteDiscountPricing(long discount, long threshold) {
    }

    @Override
    public long getTotal(Sale sale) {
        return 0;
    }
}
