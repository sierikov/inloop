import java.util.Objects;

public class Sale {
    private long preDiscountTotal;
    private ISalePricing pricing;

    public Sale(long preDiscountTotal, ISalePricing pricing) {
        Objects.requireNonNull(pricing);
        if (preDiscountTotal < 0) throw new IllegalArgumentException();

        this.preDiscountTotal = preDiscountTotal;
        this.pricing = pricing;
    }

    public static ISalePricing createPricing(DiscountType discountType, double percentage, long discount, long threshold){
        return null;
    }

    public long getPreDiscountTotal() {
        return preDiscountTotal;
    }

    public void setPricing(ISalePricing pricing) {
        Objects.requireNonNull(pricing);
        this.pricing = pricing;
    }

    public long getTotal(){
        return pricing.getTotal();
    }
}
