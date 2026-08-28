package day3_livecoding.class_problems;

public class Course {
    private String code;
    private String title;
    private int credits;
    private int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return this.credits + this.labCredits;
    }

    public void printCourseInfo() {
        System.out.println(this.code + " (" + this.title + ") total credits: " + totalCredits());
    }

    public static void main(String[] args) {
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        theoryCourse.printCourseInfo();

        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);
        labCourse.printCourseInfo();
    }
}