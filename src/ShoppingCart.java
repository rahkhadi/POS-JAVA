// src/ShoppingCart.java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Define the ShoppingCartInterface
interface ShoppingCartInterface {
    void addProduct(Product product);
    void removeProduct(int productId);
    double calculateTotalCost();
    void displayItems();
}

// Implement the ShoppingCart class using the ShoppingCartInterface
public class ShoppingCart implements ShoppingCartInterface {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(int productId) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId() == productId) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found in the cart.");
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = 0;
        for (Product product : products) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    @Override
    public void displayItems() {
        if (products.isEmpty()) {
            System.out.println("The shopping cart is empty.");
            return;
        }
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: $" + product.getPrice());
            System.out.println();
        }
    }
}
