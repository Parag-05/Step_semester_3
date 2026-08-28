package day2_livecoding.class_problems;

public class CSVStudentParser {

    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        parseStudentRecord("Ananya Verma, RA2211003010123,CSE");

        System.out.println("\nTest 2:");
        parseStudentRecord("Ananya Verma,CSE");
    }
}