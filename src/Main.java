public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        WarehouseService warehouseService = new WarehouseService(warehouse);

        Product smartphone = new Product("1", "Telefon", 899.99, 10, "Elektronik");
        Product laptop = new Product("2", "Laptop", 1299.99, 5, "Elektronik");
        Product book = new Product("3", "Harry Potter", 12.99, 20, "Böcker");

        warehouseService.addProduct(smartphone);
        warehouseService.addProduct(laptop);
        warehouseService.addProduct(book);

        Discount fridayDiscount = new FridayDiscount(null);
        Discount electronicsDiscount = new MilkDiscount(fridayDiscount);
        Discount quantityDiscount = new QuantityDiscount(electronicsDiscount);

        warehouseService.getAllProducts().forEach(product -> {
            double discountAmount = quantityDiscount.apply(product);
            System.out.println("Rabatt för " + product.getName() + ": " + discountAmount + " SEK");
            System.out.println("Rabatt beskrivning: " + quantityDiscount.getDescription(product));
            System.out.println("Slutgiltigt pris: " + (product.getPrice() - discountAmount) + " SEK");
            System.out.println("------");
        });
    }
}
