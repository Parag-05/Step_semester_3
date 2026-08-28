package day1_livecoding.class_problems;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        return new String(original).equals(new String(reversed));
    }

    public static void main(String[] args) {
        String[] testCases = {"madam", "hello"};
        for (String text : testCases) {
            boolean iter = isPalindromeIterative(text);
            boolean recur = isPalindromeRecursive(text);
            boolean arrRev = isPalindromeArrayReversal(text);
            System.out.println("Input: \"" + text + "\"");
            System.out.println("Iterative: " + (iter ? "Palindrome" : "Not Palindrome") +
                               " | Recursive: " + (recur ? "Palindrome" : "Not Palindrome") +
                               " | Array Reversal: " + (arrRev ? "Palindrome" : "Not Palindrome") + "\n");
        }
    }
}