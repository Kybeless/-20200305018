import javax.swing.*;

public class Main {
    public static <T> void main(String[] args) {

        // Lambda ->
        SwingUtilities.invokeLater(() -> {
            Inventory inventory = new Inventory();

            // Ürünleri eklemek yerine, sadece GUI'yi başlatıyoruz
            InventoryGUI<T> inventoryGUI = new InventoryGUI<T>(inventory);
            inventoryGUI.setVisible(true);

            // Rastgele bir ürün ekleyelim
            Product randomProduct = new Product("Random Item", 500.0, 5);
            inventory.addProduct(randomProduct);

            // Rastgele bir ürünü çıkaralım
            inventory.removeItem(1); // Örneğin, index 1'deki ürünü çıkaralım
            ((InventoryGUI<?>) inventoryGUI).refreshDisplay(); // Tablo yenilensin
        });
    }
}
