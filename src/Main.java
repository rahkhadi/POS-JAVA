public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        // Create a registered user first
        System.out.print("Enter registered user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter registered user name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter registered user address: ");
        String userAddress = scanner.nextLine();

        System.out.print("Enter registered user password: ");
        String password = scanner.nextLine();

        RegisteredUser registeredUser = new RegisteredUser(userId, userName, userAddress, password);

        // Interactive product addition
        ShoppingCart cart = registeredUser.getCart();
        while (true) {
            System.out.println("Add a product to the cart:");
            System.out.print("Enter product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter product name: ");
            String name = scanner.nextLine();

            System.out.print("Enter product description: ");
            String description = scanner.nextLine();

            System.out.print("Enter product price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter quantity in stock: ");
            int quantity = scanner.nextInt();

            Product product = new Product(productId, name, description, price, quantity);
            cart.addProduct(product);

            System.out.print("Do you want to add another product? (yes/no): ");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Interactive product removal
        while (true) {
            System.out.print("Do you want to remove a product from the cart? (yes/no): ");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("yes")) {
                break;
            }

            System.out.print("Enter product ID to remove: ");
            int productId = scanner.nextInt();
            cart.removeProduct(productId);
        }

        System.out.println("Shopping Cart:");
        cart.displayItems();
        System.out.println("Total Cost: $" + cart.calculateTotalCost());

        scanner.close();
    }
}
