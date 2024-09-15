import java.util.Scanner;

public class OutdoorPlant extends Plant {

    private String soilType;
    private String soilAcidityLevel;

    public OutdoorPlant() {
        // calls the parent constructor
        super();
        this.soilType = "N/A";
        this.soilAcidityLevel = "N/A";
    }

    public OutdoorPlant(String name, double price, String sku, String soilType, String soilAcidityLevel) {
        // calls the parent constructor
        super(name, price, sku);
        this.soilType = soilType;
        this.soilAcidityLevel = soilAcidityLevel;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getSoilAcidityLevel() {
        return soilAcidityLevel;
    }

    public void setSoilAcidityLevel(String soilAcidityLevel) {
        this.soilAcidityLevel = soilAcidityLevel;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Soil Type: " + getSoilType());
        System.out.println("Soil PH: " + getSoilAcidityLevel());
    }

    @Override
    public void editDetails() {
        super.editDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new soil type: ");
        String newSoilType = scanner.nextLine();
        this.setSoilType(newSoilType);

        System.out.print("Enter new soil PH: ");
        String newSoilAcidityLevel = scanner.nextLine();
        this.setSoilAcidityLevel(newSoilAcidityLevel);
    }
}