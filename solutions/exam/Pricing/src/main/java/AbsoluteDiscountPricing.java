public class AbsoluteDiscountPricing implements ISalePricing {
    private final long threshold;
    private final long discount;

    public AbsoluteDiscountPricing(long discount, long threshold) {
        if (discount < 0 || threshold < 0) throw new IllegalArgumentException();
        this.threshold = threshold;
        this.discount = discount;
    }

    @Override
    public long getTotal(Sale sale) {
        if (sale.getPreDiscountTotal() - discount > threshold)  return sale.getPreDiscountTotal() - discount;
        else return Math.min(threshold, sale.getPreDiscountTotal());
    }
}
