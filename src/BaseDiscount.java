public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }

    protected abstract boolean isApplicable(Product product);

    protected abstract double calculateDiscount(Product product);

    @Override
    public double apply(Product product) {
        if (isApplicable(product)) {
            double discount = calculateDiscount(product);
            if (nextDiscount != null) {
                discount += nextDiscount.apply(product);
            }
            return discount;
        } else {
            if (nextDiscount != null) {
                return nextDiscount.apply(product);
            } else {
                return 0;
            }
        }
    }
}
