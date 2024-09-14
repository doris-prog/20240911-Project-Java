import java.util.Scanner;

public abstract class Product implements ITaxable {
    private String name;
    private double price;
    private String sku;

    public Product() {
        // Default constructor
        this.name = "N/A";
        this.price = 0.0;
        this.sku = "N/A";
    }

    public void displayDetails() {
        System.out.println("Product Name: " + getSku());
        System.out.println("Product Price: " + getPrice());
        System.out.println("Product SKU: " + getSku());
    }

    public Product(String name, double price, String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Invalid price. Please provide a non-negative value.");
        }
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) throws IllegalArgumentException {
        if (sku != null && !sku.isEmpty()) {
            this.sku = sku;
        } else {
            throw new IllegalArgumentException("Invalid SKU. Please provide a non-empty string.");
        }
    }

    public void editDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        this.setName(newName);

        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        this.setPrice(newPrice);
        scanner.nextLine();

        System.out.print("Enter new SKU: ");
        String newSku = scanner.nextLine();
        this.setSku(newSku);
    }

    @Override
    public double calculateSalesTax() {
        double taxPercentage = 0.1; // 10% tax rate
        return getPrice() * taxPercentage;
    }
}
