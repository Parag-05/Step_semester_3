package day4_livecoding.assignment_problems;

public class MembershipCard {
    private static String libraryName;
    private static String validUntil;

    private String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
        System.out.println("Membership card issued: " + this.studentName);
    }

    public String getStudentName() {
        return studentName;
    }

    public static String getLibraryName() {
        return libraryName;
    }

    public static String getValidUntil() {
        return validUntil;
    }

    public static void main(String[] args) {
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};

        for (String name : names) {
            MembershipCard card = new MembershipCard(name);
            if (card.getStudentName() == null) {
                System.out.println(getLibraryName() + " " + getValidUntil());
            }
        }
    }
}
