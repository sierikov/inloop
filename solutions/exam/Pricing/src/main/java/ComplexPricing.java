import java.util.ArrayList;

import java.util.List;
import java.util.Objects;

public abstract class ComplexPricing implements ISalePricing {
    private List<ISalePricing> pricings = new ArrayList<>();

    public ComplexPricing( ISalePricing pricing){

    }

    protected ComplexPricing() {
    }

    public void add(ISalePricing pricing) {
        Objects.requireNonNull(pricing);
        pricings.add(pricing);
    }

    public List<ISalePricing> getPricings() {
        return pricings;
    }

    @Override
    public long getTotal(Sale sale) {
        return 0;
    }
}
