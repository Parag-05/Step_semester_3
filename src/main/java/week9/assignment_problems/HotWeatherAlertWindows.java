package main.java.week9.assignment_problems;

public class HotWeatherAlertWindows {

    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || readings.length < k) {
            return 0;
        }

        int alertCount = 0;
        long currentSum = 0;
        long targetSum = (long) k * threshold;

        for (int i = 0; i < k; i++) {
            currentSum += readings[i];
        }

        if (currentSum >= targetSum) {
            alertCount++;
        }

        for (int i = k; i < readings.length; i++) {
            currentSum += readings[i] - readings[i - k];
            if (currentSum >= targetSum) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 5, 5, 5, 8}; // 3 tens/fives block matching PDF example comment
        int k = 3;
        int threshold = 4;

        System.out.println(countAlerts(readings, k, threshold));
    }
}