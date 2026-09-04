package day4_livecoding.class_problems;

public class SrmStudentBatch {
    private static String collegeName;
    private static int academicYear;

    private String name;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = 2026;
        System.out.println("College info loaded");
    }

    public SrmStudentBatch(String name) {
        this.name = name;
        System.out.println("Student record created: " + this.name);
    }

    public String getName() {
        return name;
    }

    public static String getCollegeName() {
        return collegeName;
    }

    public static int getAcademicYear() {
        return academicYear;
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (String studentName : names) {
            SrmStudentBatch student = new SrmStudentBatch(studentName);
            if (student.getName() == null) {
                System.out.println(getCollegeName() + " " + getAcademicYear());
            }
        }
    }
}
