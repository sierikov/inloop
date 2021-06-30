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
        this.getPricings().stream()
                .filter(pricing -> pricing.getTotal(sale) < currentTotal.get())
                .forEach(pricing -> currentTotal.set(pricing.getTotal(sale)));
        return currentTotal.get();
    }
}
