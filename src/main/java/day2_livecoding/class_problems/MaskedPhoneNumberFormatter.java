package day2_livecoding.class_problems;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFour = phone.substring(6);
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.insert(6, "-");
        masked.append(lastFour);

        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println("Input: \"9876543210\" -> " + maskPhoneNumber("9876543210"));
        System.out.println("Input: \"98765\" -> " + maskPhoneNumber("98765"));
    }
}