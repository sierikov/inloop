public abstract class ComplexPricing implements ISalePricing {
    private ISalePricing pricing;

    public ComplexPricing(){ }

    public ComplexPricing(ISalePricing pricing) {
        this.pricing = pricing;
    }

    public ISalePricing getPricings() {
        return pricing;
    }

    public void add(ISalePricing pricing){

    }

    @Override
    public long getTotal(Sale sale) {
        return 0;
    }
}
