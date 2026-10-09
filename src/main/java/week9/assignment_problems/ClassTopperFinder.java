package main.java.week9.assignment_problems;

class TopperResult {
    int rowIndex;
    int total;

    public TopperResult(int rowIndex, int total) {
        this.rowIndex = rowIndex;
        this.total = total;
    }
}

public class ClassTopperFinder {

    public static TopperResult findTopper(int[][] marks) {
        int maxTotal = -1;
        int topperIndex = -1;

        for (int r = 0; r < marks.length; r++) {
            int currentTotal = 0;
            for (int c = 0; c < marks[r].length; c++) {
                currentTotal += marks[r][c];
            }

            // Updating strictly on greater keeps the smallest row index for ties
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                topperIndex = r;
            }
        }

        return new TopperResult(topperIndex, maxTotal);
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        TopperResult result = findTopper(marks);
        System.out.printf("(%d, %d)\n", result.rowIndex, result.total);
    }
}