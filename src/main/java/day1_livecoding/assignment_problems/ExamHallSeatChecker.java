package day1_livecoding.assignment_problems;

public class ExamHallSeatChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] testCase1 = {101, 102, 103, 102, 105};
        int[] testCase2 = {101, 102, 103, 104, 105};

        System.out.print("Test 1 Output: ");
        checkDuplicateSeats(testCase1);

        System.out.print("Test 2 Output: ");
        checkDuplicateSeats(testCase2);
    }
}