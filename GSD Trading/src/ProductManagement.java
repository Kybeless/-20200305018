import java.util.List;

// ProductManagement.java (Interface)
public interface ProductManagement {
    void addProduct(Product product);
    void removeProduct(Product product);
    List<Product> listProducts();
}
