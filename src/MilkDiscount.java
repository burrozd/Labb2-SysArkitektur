public class MilkDiscount extends BaseDiscount {
    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return "mjölk".equalsIgnoreCase(product.getCategory());
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 0.05 * product.getPrice();
    }

    @Override
    public String getDescription(Product product) {
        return "Mjälk rabatt: 5%";
    }
}
