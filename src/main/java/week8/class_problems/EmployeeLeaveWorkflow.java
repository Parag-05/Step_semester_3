package main.java.week8.class_problems;

abstract class Employee {
    private String id;
    private String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public abstract String getRole();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() { return "FullTimeEmployee"; }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() { return "PartTimeEmployee"; }
}

class Contractor extends Employee {
    public Contractor(String id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() { return "Contractor"; }
}

class LeaveRequest {
    private Employee employee;
    private String dateRange;
    private String status;

    public LeaveRequest(Employee employee, String dateRange) {
        this.employee = employee;
        this.dateRange = dateRange;
        this.status = "Pending";
        System.out.println("Leave request submitted for " + employee.getName() + " (" + dateRange + "). Status: Pending.");
    }

    public void approve(String reviewer) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from " + status + " to Pending.");
            return;
        }
        this.status = "Approved";
        System.out.println(employee.getName() + "'s leave request (" + dateRange + ") approved. Status: Approved.");
    }

    public void reject(String reviewer) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from " + status + " to Pending.");
            return;
        }
        this.status = "Rejected";
        System.out.println(employee.getName() + "'s leave request (" + dateRange + ") rejected. Status: Rejected.");
    }

    public void setStatusToPending() {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from " + status + " to Pending.");
        }
    }

    public String getStatus() { return status; }
}

public class EmployeeLeaveWorkflow {
    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("E101", "John");
        Employee jane = new PartTimeEmployee("E102", "Jane");

        LeaveRequest johnRequest = new LeaveRequest(john, "Jan 1-5");
        johnRequest.approve("Alice");

        LeaveRequest janeRequest = new LeaveRequest(jane, "Feb 10-11");
        janeRequest.reject("Bob");

        johnRequest.setStatusToPending();
    }
}