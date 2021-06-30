public class Main {

    public static void main(String[] args) {
        Sale sale1;
        ISalePricing p1, p2, p3, p4, p5;
        p1 = Sale.createPricing(DiscountType.PERCENTAGEDISCOUNT, 10.0, 0, 0);
        p2 = Sale.createPricing(DiscountType.PERCENTAGEDISCOUNT, 5.0, 0, 0);
        p3 = Sale.createPricing(DiscountType.ABSOLUTEDISCOUNT, 0, 500, 5000);
        p4 = Sale.createPricing(DiscountType.ABSOLUTEDISCOUNT, 0, 3000, 15000);
        p5 = Sale.createPricing(DiscountType.ABSOLUTEDISCOUNT, 0, 1900, 8000);
        BestForCustomerPricing p = new BestForCustomerPricing(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        sale1 = new Sale(10000, p);
        System.out.println("BestForCustomer Price = " + sale1.getTotal()
                / 100.00 + " EUR");
    }
}
