package day2_livecoding.assignment_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        try {
            if (feedback == null || feedback.trim().isEmpty()) {
                System.out.println("No feedback provided.");
                return;
            }

            Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

            String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");
            String[] words = cleanedText.split("\\s+");

            Map<String, Integer> frequencyMap = new HashMap<>();

            for (String word : words) {
                if (!word.isEmpty() && !stopWords.contains(word)) {
                    frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
                }
            }

            frequencyMap.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (Exception e) {
            System.out.println("Error processing word frequency: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFeedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(inputFeedback);
    }
}