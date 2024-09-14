
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Product> productList = new ArrayList<>();
    private static ArrayList<Membership>membershipList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            int choice = displayMenu();

            if (choice == 1) {
                addNewProduct();
            } else if (choice == 2) {
                displayProducts(productList);
            } else if (choice == 3) {
                addNewMembership();
            } else if (choice == 4) {
                displayMemberships();
            } else if (choice == 5) {
                displayTaxableItems();
            } else if (choice == 6) {
                break;
            }
        } while (true);
    }

        private static int displayMenu() {

            int choice = 0;

            while (true) {
                System.out.println();
                System.out.println("----------------------");
                System.out.println("Menu: ");
                System.out.println("----------------------");
                System.out.println("1. Add a product");
                System.out.println("2. List all products");
                System.out.println("3. Add a membership");
                System.out.println("4. List all memberships");
                System.out.println("5. Display all taxable items");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt(); // consume the newline character
                scanner.nextLine(); // consume the newline character after scanner.nextInt()
                if (choice >= 1 && choice <= 6) {
                    break;
                }
            }
            System.out.println();
            return choice;
        }

        private static void addNewMembership() {
            System.out.println("Enter membership type (Silver / Gold): ");
            String type = scanner.nextLine();
            System.out.println("Enter membership cost: ");
            double cost = scanner.nextDouble();
            scanner.nextLine();

            Membership newMembership = new Membership(type, cost);
            membershipList.add(newMembership);
            System.out.println();
            System.out.println("Membership added successfully !");
        }

        private static void displayMemberships() {
            System.out.println("----------------------");
            System.out.println("Memberships: ");
            System.out.println("----------------------");
            for (Membership membership : membershipList) {
                System.out.println("Type: " + membership.getType());
                System.out.println("Cost: $" + membership.getCost());
                System.out.println("Sales Tax: $" + membership.calculateSalesTax());
                System.out.println("----------------------");
            }
        }

private static void addNewProduct() {
    System.out.println("Enter the name of the product: ");
    String name = scanner.nextLine();
    System.out.println("Enter the price of the product: ");
    double price = scanner.nextDouble();
    scanner.nextLine(); // consume the newline character in the buffer
    System.out.println("Enter the SKU of the product: ");
    String sku = scanner.nextLine();
    System.out.println();

    while (true) {
        System.out.println("Choose the type of product: ");
        System.out.println("1. Physical Product");
        System.out.println("2. Digital Product");
        System.out.print("Enter product type: ");
        int choice = scanner.nextInt();
        System.out.println();

        if (choice == 1) {
            System.out.print("Enter the size of the physical product: ");
            scanner.nextLine();
            String size = scanner.nextLine();
            System.out.print("Enter the weight of the physical product: ");
            double weight = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter the color of the physical product: ");
            String color = scanner.nextLine();

            PhysicalProduct physicalProduct = new PhysicalProduct(name, price, sku, size, weight, color);
            productList.add(physicalProduct);
            System.out.println();
            System.out.print("Physical product added successfully !");
            break;
        } else if (choice == 2) {
            scanner.nextLine();
            System.out.print("Enter the format of the digital product: ");
            String format = scanner.nextLine();
            System.out.print("Enter the download link of the digital product: ");
            String downloadLink = scanner.nextLine();

            DigitalProduct digitalProduct = new DigitalProduct(name, price, sku, format, downloadLink);
            productList.add(digitalProduct);
            System.out.println();
            System.out.print("Digital product added successfully !");
            break;
        } else {
            System.out.print("Invalid choice. Please try again.");
        }
    }
}

    public static void displayProducts(ArrayList<Product> productList) {
        for (int i = 0; i < productList.size(); i++) {
            Product p = productList.get(i);
            // print out the index
            System.out.println("ProductIndex: " + i);
            p.displayDetails();
            System.out.println();
        }

        System.out.println("Choose an option: ");
        System.out.println("1. Edit a product");
        System.out.println("2. Delete a product");
        System.out.println("3. Exit");
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();
        System.out.println();

        if (option == 1) {
            System.out.print("Enter the index of the product you want to edit: ");
            int index = scanner.nextInt();
            if (index >= 0 && index < productList.size()) {
                Product productToEdit = productList.get(index);
                System.out.println("ProductIndex To Edit: " + index);
                editProduct(productToEdit);
            } else {
                System.out.print("Invalid index.");
            }
        } else if (option == 2) {
            System.out.println("Enter the index of the product you want to delete: ");
            int index = scanner.nextInt();
            if (index >=0 && index < productList.size()) {
                productList.remove(index);
                System.out.println("Product deleted.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }

    public static void editProduct(Product p) {
        p.editDetails();
    }

    private static void displayTaxableItems() {
        ArrayList<ITaxable>taxableItems = new ArrayList<>();

        // Add all Product instances to the taxableItems list
        for (Product product : productList) {
            taxableItems.add(product);
        }

        // Add all Membership instances to the taxableItems list
        for (Membership membership : membershipList) {
            taxableItems.add(membership);
        }

        // Display details of each taxable item
        System.out.println("Taxable Items: ");

        for (ITaxable item : taxableItems) {
            System.out.println("Sales Tax: $" + item.calculateSalesTax());
            System.out.println("----------------------");
        }
    }
}
