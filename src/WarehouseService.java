import java.util.List;

public class WarehouseService {
    private final Warehouse warehouse;

    public WarehouseService(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void addProduct(Product product) {
        warehouse.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return warehouse.getAllProducts();
    }

    public Product getProductById(String productId) {
        return warehouse.getProductById(productId);
    }

    public List<Product> getProductsByCategory(String category) {
        return warehouse.getProductsByCategory(category);
    }

    public List<Product> getProductsPaginated(String fromProduct, int limit) {
        return warehouse.getProductsPaginated(fromProduct, limit);
    }
}
