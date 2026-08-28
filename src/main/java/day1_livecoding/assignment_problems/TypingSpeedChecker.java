package day1_livecoding.assignment_problems;

public class TypingSpeedChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int total = original.length();
        int firstMismatchPos = -1;
        char origChar = ' ', typedChar = ' ';

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        double accuracy = ((double) matched / total) * 100;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", matched, total, accuracy);
        if (firstMismatchPos != -1) {
            System.out.println("First Mismatch at position " + firstMismatchPos + " ('" + origChar + "' vs '" + typedChar + "')");
        } else {
            System.out.println("No Mismatches");
        }
    }

    public static void main(String[] args) {
        System.out.print("Test 1: ");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.print("Test 2: ");
        checkTypingAccuracy("coding", "coding");
    }
}