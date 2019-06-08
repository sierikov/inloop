import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class BestForCustomerPricing extends ComplexPricing {
    public BestForCustomerPricing(ISalePricing pricing) {
        Objects.requireNonNull(pricing);
        this.add(pricing);
    }

    @Override
    public long getTotal(Sale sale) {
        AtomicLong currentTotal = new AtomicLong();
        currentTotal.set(sale.getPreDiscountTotal());
        System.out.println(currentTotal.get());
        this.getPricings().forEach(
                pricing -> {
                    if (pricing.getTotal(sale) < currentTotal.get()) {
                        System.out.println(pricing.getTotal(sale));
                        currentTotal.set(pricing.getTotal(sale));
                    }});
        System.out.println(currentTotal.get());
        return currentTotal.get();
    }
}
