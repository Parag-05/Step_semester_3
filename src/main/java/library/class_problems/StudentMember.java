package main.java.library.class_problems;

public class StudentMember extends LibraryMember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student Member | ID: " + getMemberId() + " | Course: " + course + " | Books Borrowed: " + getBooksBorrowed());
    }

    @Override
    protected void chargeFine(int amount) {
        // Problem 3: Student members get a discount: halve the fine before recording[cite: 4]
        super.chargeFine(amount / 2);
    }
}