package main.java.week9.assignment_problems;

import java.util.Arrays;

public class MergingTwoTokenQueues {

    // Optimal Two-Pointer Merge: O(m + n) Time, O(m + n) Space
    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        int m = counterA.length;
        int n = counterB.length;
        int[] result = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (counterA[i] <= counterB[j]) {
                result[k++] = counterA[i++];
            } else {
                result[k++] = counterB[j++];
            }
        }

        while (i < m) {
            result[k++] = counterA[i++];
        }

        while (j < n) {
            result[k++] = counterB[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] counterA1 = {3, 8, 15, 20};
        int[] counterB1 = {5, 8, 12};
        System.out.println(Arrays.toString(mergeTokens(counterA1, counterB1)));

        int[] counterA2 = {};
        int[] counterB2 = {4, 9};
        System.out.println(Arrays.toString(mergeTokens(counterA2, counterB2)));
    }
}