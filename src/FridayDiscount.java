import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {
    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return DayOfWeek.FRIDAY.equals(LocalDate.now().getDayOfWeek());
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 0.1 * product.getPrice();
    }

    @Override
    public String getDescription(Product product) {
        return "Fredags rabatt: 10%";
    }
}
