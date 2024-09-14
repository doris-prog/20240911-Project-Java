import java.util.Scanner;

public class DigitalProduct extends Product {

    private String format;
    private String downloadLink;

    public DigitalProduct() {
        // calls the parent constructor
        super();
        this.format = "N/A";
        this.downloadLink = "N/A";
    }

    public DigitalProduct(String name, double price, String sku, String format, String downloadLink) {
        // calls the parent constructor
        super(name, price, sku);
        this.format = format;
        this.downloadLink = downloadLink;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Digital Product Format: " + getFormat());
        System.out.println("Digital Product Download Link: " + getDownloadLink());
    }

    @Override
    public void editDetails() {
        super.editDetails();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new format: ");
        String newFormat = scanner.nextLine();
        this.setFormat(newFormat);


        System.out.print("Enter new download link: ");
        String newDownloadLink = scanner.nextLine();
        this.setDownloadLink(newDownloadLink);
    }
}