import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Warehouse {
    private List<Product> productList = new CopyOnWriteArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getAllProducts() {
        return List.copyOf(productList);
    }

    public Product getProductById(String productId) {
        return productList.stream()
                .filter(product -> productId.equals(product.getId()))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProductsByCategory(String category) {
        return productList.stream()
                .filter(product -> category.equalsIgnoreCase(product.getCategory()))
                .toList();
    }

    public List<Product> getProductsPaginated(String fromProduct, int limit) {
        int startIndex = 0;
        int endIndex = Math.min(startIndex + limit, productList.size());
        return productList.subList(startIndex, endIndex);
    }
}
