package day1_livecoding.class_problems;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        char[] arr = customerName.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String originalName = "Sunil";
        String reversedName = reverseCustomerName(originalName);

        System.out.println("Original Name: " + originalName);
        System.out.println("Reversed Name: " + reversedName);
    }
}