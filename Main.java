
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Plant> plantList = new ArrayList<>();
    private static ArrayList<Membership>membershipList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            int choice = displayMenu();

            if (choice == 1) {
                addNewPlant();
            } else if (choice == 2) {
                displayPlants(plantList);
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
                System.out.println("1. Add Plant");
                System.out.println("2. List all plants");
                System.out.println("3. Add membership");
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
                System.out.println("Cost: $%.2f" + membership.getCost());
                System.out.println("Sales Tax: $%.2f" + membership.calculateSalesTax());
                System.out.println("----------------------");
            }
        }

private static void addNewPlant() {
    System.out.print("Enter name of the plant: ");
    String name = scanner.nextLine();
    System.out.print("Enter price of the plant: ");
    double price = scanner.nextDouble();
    scanner.nextLine(); // consume the newline character in the buffer
    System.out.print("Enter SKU of the plant: ");
    String sku = scanner.nextLine();
    System.out.println();

    while (true) {
        System.out.println("Choose the type of plant: ");
        System.out.println("1. Indoor Plant");
        System.out.println("2. Outdoor Plant");
        System.out.print("Enter plant type: ");
        int choice = scanner.nextInt();
        System.out.println();

        if (choice == 1) {
            System.out.print("Enter plant estimated mature size range: ");
            scanner.nextLine();
            String size = scanner.nextLine();
            System.out.print("Enter sun exposure time: ");
            int sunExposeTime = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter water requirement: ");
            String waterRequire = scanner.nextLine();

            IndoorPlant indoorPlant = new IndoorPlant(name, price, sku, size, sunExposeTime, waterRequire);
            plantList.add(indoorPlant);
            System.out.println();
            System.out.print("Indoor plant added successfully !");
            break;
        } else if (choice == 2) {
            scanner.nextLine();
            System.out.print("Enter the soil type: ");
            String soilType = scanner.nextLine();
            System.out.print("Enter the soil PH level: ");
            String soilAcidityLevel = scanner.nextLine();

            OutdoorPlant outdoorPlant = new OutdoorPlant(name, price, sku, soilType, soilAcidityLevel);
            plantList.add(outdoorPlant);
            System.out.println();
            System.out.print("Outdoor plant added successfully !");
            break;
        } else {
            System.out.print("Invalid choice. Please try again.");
        }
    }
}

    public static void displayPlants(ArrayList<Plant> plantList) {
        for (int i = 0; i < plantList.size(); i++) {
            Plant p = plantList.get(i);
            // print out the index
            System.out.println("Plant Index: " + i);
            p.displayDetails();
            System.out.println();
        }

        System.out.println("Choose an option: ");
        System.out.println("1. Edit plant");
        System.out.println("2. Delete plant");
        System.out.println("3. Exit");
        System.out.print("Enter your option: ");
        int option = scanner.nextInt();
        System.out.println();

        if (option == 1) {
            System.out.print("Enter the index of the plant you want to edit: ");
            int index = scanner.nextInt();
            if (index >= 0 && index < plantList.size()) {
                Plant plantToEdit = plantList.get(index);
                System.out.println("Plant Index To Edit: " + index);
                editPlant(plantToEdit);
            } else {
                System.out.print("Invalid index.");
            }
        } else if (option == 2) {
            System.out.println("Enter the index of the product you want to delete: ");
            int index = scanner.nextInt();
            if (index >=0 && index < plantList.size()) {
                plantList.remove(index);
                System.out.println("Plant deleted.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }

    public static void editPlant(Plant p) {
        p.editDetails();
    }

    private static void displayTaxableItems() {
        ArrayList<ITaxable>taxableItems = new ArrayList<>();

        // Add all Product instances to the taxableItems list
        for (Plant plant : plantList) {
            taxableItems.add(plant);
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
