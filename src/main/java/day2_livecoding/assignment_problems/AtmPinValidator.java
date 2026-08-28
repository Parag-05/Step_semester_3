package day2_livecoding.assignment_problems;

public class AtmPinValidator {

    public static void checkPinLength(String pin) {
        try {
            if (pin == null || pin.length() != 4) {
                System.out.println("Invalid PIN must be exactly 4 digits.");
            } else {
                System.out.println("PIN length OK.");
            }
        } catch (Exception e) {
            System.out.println("Error processing PIN: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String userInput1 = "482";
        System.out.print("Input: \"" + userInput1 + "\" -> ");
        checkPinLength(userInput1);

        String userInput2 = "4820";
        System.out.print("Input: \"" + userInput2 + "\" -> ");
        checkPinLength(userInput2);
    }
}