package main.java.library.assignment_problems;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testing Assignment Q1: Sign-Up Batch ===");
        String[] batch = {"MEM1", "MEM123", "AB", "MEM99"};
        System.out.println(GymMember.signUpBatch(batch, 1000));

        System.out.println("\n=== Testing Assignment Q5: Referral Code Validator ===");
        System.out.println(GymMember.isValidReferralCode("G45B"));
        System.out.println(GymMember.isValidReferralCode("G4B"));
        System.out.println(GymMember.isValidReferralCode("X45B"));

        System.out.println("\n=== Testing Assignment Q5: Weekly Check-In ===");
        GymMember[] auditBatch = {
            new GroupClassMember("GRP1", 1500, "Zumba"),
            null,
            new GymMember("MEM2", 1000)
        };
        System.out.println(GymMember.processWeeklyCheckIn(auditBatch));
    }
}