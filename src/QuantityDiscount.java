public class QuantityDiscount extends BaseDiscount {
    private static final int MIN_QUANTITY_FOR_DISCOUNT = 5;

    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.getQuantity() >= MIN_QUANTITY_FOR_DISCOUNT;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 10 * product.getQuantity();
    }

    @Override
    public String getDescription(Product product) {
        return "Kvantitetsrabatt: 10 SEK per produkt för kvantitet >= 5";
    }
}
