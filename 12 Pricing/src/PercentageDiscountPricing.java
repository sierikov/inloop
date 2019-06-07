public class PercentageDiscountPricing implements ISalePricing {
    private double percentage;

    public PercentageDiscountPricing(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public long getTotal(Sale sale) {
        return (long) percentage;
    }
}
