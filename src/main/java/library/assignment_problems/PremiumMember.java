package main.java.library.assignment_problems;

public class PremiumMember extends GymMember {
    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.println("Premium Member | Trainer: " + trainerName + " | Sessions: " + getSessionsAttended());
    }

    @Override
    protected void chargeLateFee(int amount) {
        // Premium members get a discount: halve the late fee before recording[cite: 3]
        super.chargeLateFee(amount / 2);
    }
}