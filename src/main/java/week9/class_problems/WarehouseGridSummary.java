package main.java.week9.class_problems;

class GridResult {
    int totalItems;
    int maxRow;
    int maxCol;

    public GridResult(int totalItems, int maxRow, int maxCol) {
        this.totalItems = totalItems;
        this.maxRow = maxRow;
        this.maxCol = maxCol;
    }
}

public class WarehouseGridSummary {

    public static GridResult warehouseSummary(int[][] grid) {
        int totalItems = 0;
        int maxItems = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int currentVal = grid[r][c];
                totalItems += currentVal;

                if (currentVal > maxItems) {
                    maxItems = currentVal;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        return new GridResult(totalItems, maxRow, maxCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        GridResult result = warehouseSummary(grid);
        System.out.printf("(%d, (%d, %d))\n", result.totalItems, result.maxRow, result.maxCol);
    }
}