// Inventory.java
import java.util.ArrayList;
import java.util.List;

public class Inventory<T>  { // Generic class

    private List<T> items; // Generic collections
    private List<Product> products;

    public Inventory() {
        this.items = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    // Polymorphism
    public void addItem(T item) {
        if (item instanceof Product) {
            products.add((Product) item);
            System.out.println("Product added: " + item);
        } else {
            items.add(item);
            System.out.println("Item added: " + item);
        }
    }

    public void removeItem(T item) {
        if (item instanceof Product) {
            products.remove(item);
            System.out.println("Product removed: " + item);
        } else {
            items.remove(item);
            System.out.println("Item removed: " + item);
        }
    }

    public List<T> listItems() {
        System.out.println("Items in inventory:");
        for (T item : items) {
            System.out.println(item);
        }
        return items;
    }

    public void removeItemAt(int index) {
        if (index >= 0 && index < items.size()) {
            T removedItem = items.remove(index);
            System.out.println("Item removed at index " + index + ": " + removedItem);
        } else if (index >= items.size() && index < items.size() + products.size()) {
            int productIndex = index - items.size();
            Product removedProduct = products.remove(productIndex);
            System.out.println("Product removed at index " + productIndex + ": " + removedProduct);
        } else {
            System.out.println("Invalid index");
        }
    }


    public void addProduct(Product randomProduct) {
        products.add(randomProduct);
        System.out.println("Product added: " + randomProduct);
    }

    public List<Product> listProducts() {
        System.out.println("Products in inventory:");
        for (Product product : products) {
            System.out.println(product);
        }
        return products;
    }



    // Diğer metodlar ve main fonksiyonu aynı kalır
}
