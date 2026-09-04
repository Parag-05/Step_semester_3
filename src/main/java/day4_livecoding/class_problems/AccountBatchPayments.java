package day4_livecoding.class_problems;

class FeeAccount {
    public void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    @Override
    public void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}

public class AccountBatchPayments {
    public static void processPayment(FeeAccount account, double amount) {
        account.pay(amount);
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new FeeAccount(),
            new FeeAccount()
        };

        int hostelCount = 0;
        int dayScholarCount = 0;

        for (FeeAccount acc : accounts) {
            if (acc instanceof HostelFeeAccount) {
                hostelCount++;
            } else if (acc instanceof FeeAccount) {
                dayScholarCount++;
            }
            processPayment(acc, 60000);
        }

        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}
