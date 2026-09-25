package main.java.library.assignment_problems;

public class GroupClassMember extends GymMember {
    private String className;

    public GroupClassMember(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public void displayInfo() {
        System.out.println("Group Class Member | Class: " + className + " | Sessions: " + getSessionsAttended());
    }
}