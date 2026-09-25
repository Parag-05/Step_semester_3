package main.java.library.class_problems;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing Q1: Batch Enrollment ===");
        String[] batch = {"MEM1", "STU123", "AB", "FAC99"};
        System.out.println(LibraryMember.enrollBatch(batch, 3));

        System.out.println("\n=== Testing Q5: Renewal Code Validator ===");
        System.out.println(LibraryMember.isValidRenewalCode("R12A")); // true
        System.out.println(LibraryMember.isValidRenewalCode("R1A"));  // false
        System.out.println(LibraryMember.isValidRenewalCode("X12A")); // false

        System.out.println("\n=== Testing Q5: Nightly Audit ===");
        LibraryMember[] auditBatch = {
            new FacultyMember("FAC1", 5, "Physics"),
            null,
            new LibraryMember("MEM2", 3)
        };
        System.out.println(LibraryMember.processNightlyAudit(auditBatch));
    }
}
