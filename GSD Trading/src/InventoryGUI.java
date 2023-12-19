import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InventoryGUI<T> extends JFrame { // Generic class
    private Inventory inventory;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField quantityField;
    private JButton addButton;
    private JButton removeButton;
    private JTable table1;

    public InventoryGUI(Inventory inventory) {
        this.inventory = inventory;

        setTitle("Inventory Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        nameField = new JTextField(15);
        priceField = new JTextField(8);
        quantityField = new JTextField(5);
        addButton = new JButton("Add Product");
        removeButton = new JButton("Remove Product");

        addButton.addActionListener(e -> addProductToInventory());
        removeButton.addActionListener(e -> {
            int selectedIndex = table1.getSelectedRow(); // Seçili indeksi al
            inventory.removeItemAt(selectedIndex); // İlgili indeksteki ürünü kaldır
            refreshDisplay(); // Ürün kaldırıldıktan sonra tabloyu yenile
        });


        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        add(inputPanel, BorderLayout.NORTH);

        table1 = new JTable();
        refreshDisplay();
        JScrollPane scrollPane = new JScrollPane(table1);
        add(scrollPane, BorderLayout.CENTER);

        pack();
    }

    private void addProductToInventory() {
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        Product newProduct = new Product(name, price, quantity);
        inventory.addProduct(newProduct);
        refreshDisplay();
    }

    void refreshDisplay() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Quantity");

        List<Product> products = inventory.listProducts();
        for (Product product : products) {
            model.addRow(new Object[]{product.getName(), product.getPrice(), product.getQuantity()});
        }

        table1.setModel(model);
    }

    public void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Inventory inventory = new Inventory();
            InventoryGUI<T> inventoryGUI = new InventoryGUI<T>(inventory);
            inventoryGUI.setVisible(true);
        });
    }
}
