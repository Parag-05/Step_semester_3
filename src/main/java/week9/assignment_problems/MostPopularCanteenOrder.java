package main.java.week9.assignment_problems;

import java.util.HashMap;
import java.util.Map;

class OrderResult {
    String item;
    int count;

    public OrderResult(String item, int count) {
        this.item = item;
        this.count = count;
    }
}

public class MostPopularCanteenOrder {

    // Hash-based approach: O(n) Time, O(u) Space
    public static OrderResult mostPopular(String[] orders) {
        Map<String, Integer> counts = new HashMap<>();

        // Pass 1: Count frequency of each order
        for (String order : orders) {
            counts.put(order, counts.getOrDefault(order, 0) + 1);
        }

        String maxItem = "";
        int maxCount = -1;

        // Pass 2: Iterate original order array to select highest count (and break ties by first occurrence)
        for (String order : orders) {
            int count = counts.get(order);
            if (count > maxCount) {
                maxCount = count;
                maxItem = order;
            }
        }

        return new OrderResult(maxItem, maxCount);
    }

    public static void main(String[] args) {
        String[] orders1 = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        OrderResult res1 = mostPopular(orders1);
        System.out.printf("(\"%s\", %d)\n", res1.item, res1.count);

        String[] orders2 = {"tea", "coffee", "coffee", "tea"};
        OrderResult res2 = mostPopular(orders2);
        System.out.printf("(\"%s\", %d)\n", res2.item, res2.count);
    }
}