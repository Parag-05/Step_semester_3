package day2_livecoding.assignment_problems;

public class ProductInventoryParser {

    public static void parseInventoryRecord(String csvLine) {
        try {
            if (csvLine == null || csvLine.trim().isEmpty()) {
                System.out.println("Invalid Record");
                return;
            }

            String[] fields = csvLine.split(",");

            if (fields.length != 3) {
                System.out.println("Invalid Record");
                return;
            }

            String productName = fields[0].trim();
            String sku = fields[1].trim();
            String quantity = fields[2].trim();

            System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
        } catch (Exception e) {
            System.out.println("Error parsing record: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String testInput1 = "Wireless Mouse, WM-2201,150";
        System.out.print("Test 1: ");
        parseInventoryRecord(testInput1);

        String testInput2 = "Wireless Mouse, 150";
        System.out.print("Test 2: ");
        parseInventoryRecord(testInput2);
    }
}
