import java.util.Scanner;

public class IndoorPlant extends Plant {

    private String size;
    private int sunExposeTime;
    private String waterRequire;

    public IndoorPlant() {
        // calls the parent constructor
        super();
        this.size = "N/A";
        this.sunExposeTime = 0;
        this.waterRequire = "N/A";
    }

    public IndoorPlant(String name, double price, String sku, String size, int sunExposeTime, String waterRequire) {
        // calls the parent constructor
        super(name, price, sku);
        this.size = size;
        this.sunExposeTime = sunExposeTime;
        this.waterRequire = waterRequire;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSunExposeTime() {
        return sunExposeTime;
    }

    public void setSunExposeTime(int sunExposeTime) {
        this.sunExposeTime = sunExposeTime;
    }

    public String getWaterRequire() {
        return waterRequire;
    }

    public void setWaterRequire(String waterRequire) {
        this.waterRequire = waterRequire;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Indoor Plant Size: " + getSize() + " ft");
        System.out.println("Sun Exposure Time: " + getSunExposeTime() + " hrs");
        System.out.println("Water Requirement: " + getWaterRequire() + " times");
    }

    @Override
    public void editDetails() {

        super.editDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the new size: ");
        String newSize = scanner.nextLine();
        this.setSize(newSize);

        System.out.print("Enter new sun exposure time: ");
        int newSunExposeTime = scanner.nextInt();
        this.setSunExposeTime(newSunExposeTime);
        scanner.nextLine();

        System.out.print("Enter new water requirement: ");
        String newWaterRequire = scanner.nextLine();
        this.setWaterRequire(newWaterRequire);

    }
}
