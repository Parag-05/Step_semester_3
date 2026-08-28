package day2_livecoding.assignment_problems;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        try {
            if (sentence == null || sentence.trim().isEmpty()) {
                return "";
            }

            String[] words = sentence.split(" ");
            StringBuilder resultBuilder = new StringBuilder();

            for (int i = 0; i < words.length; i++) {
                StringBuilder wordBuilder = new StringBuilder(words[i]);
                resultBuilder.append(wordBuilder.reverse().toString());
                
                if (i < words.length - 1) {
                    resultBuilder.append(" ");
                }
            }

            return resultBuilder.toString();
        } catch (Exception e) {
            System.out.println("Error encoding sentence: " + e.getMessage());
            return "";
        }
    }

    public static void main(String[] args) {
        String userInput = "hello club";
        String result = reverseEachWord(userInput);
        System.out.println("Input: \"" + userInput + "\" -> Output: " + result);
    }
}
