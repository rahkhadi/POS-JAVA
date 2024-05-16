// src/RegisteredUser.java
public class RegisteredUser extends User {
    private String password;
    private ShoppingCart cart;

    public RegisteredUser(int userId, String name, String address, String password) {
        super(userId, name, address);
        this.password = password;
        this.cart = new ShoppingCart();
    }

    public String getPassword() {
        return password;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void saveCart() {
        // Implementation to save the cart for future sessions
    }
}
