package day2_livecoding.assignment_problems;

public class LibraryIsbnValidator {

    public static String normalizeCode(String raw) {
        try {
            if (raw == null) {
                return "";
            }
            String trimmed = raw.trim();
            if (trimmed.length() < 3) {
                return trimmed;
            }
            return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
        } catch (Exception e) {
            System.out.println("Error normalizing code: " + e.getMessage());
            return raw;
        }
    }

    public static String validateAndFormat(String code) {
        try {
            if (code == null || code.length() != 13) {
                return "Invalid: wrong length";
            }

            for (int i = 0; i < 3; i++) {
                if (!Character.isLetter(code.charAt(i))) {
                    return "Invalid: publisher code must be 3 letters";
                }
            }

            for (int i = 3; i < 13; i++) {
                if (!Character.isDigit(code.charAt(i))) {
                    return "Invalid: remaining 10 characters must be digits";
                }
            }

            String pubCode = code.substring(0, 3);
            String year = code.substring(3, 7);
            String catalog = code.substring(7, 13);

            StringBuilder formattedResult = new StringBuilder();
            formattedResult.append("[").append(pubCode).append("] YEAR: ")
                           .append(year).append(" | CATALOG: ").append(catalog);

            return formattedResult.toString();
        } catch (Exception e) {
            return "Error validating code: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String rawInput1 = "pen2026004251";
        String normalized1 = normalizeCode(rawInput1);
        System.out.println("Test 1: " + validateAndFormat(normalized1));

        String rawInput2 = "12N2026004251";
        String normalized2 = normalizeCode(rawInput2);
        System.out.println("Test 2: " + validateAndFormat(normalized2));
    }
}