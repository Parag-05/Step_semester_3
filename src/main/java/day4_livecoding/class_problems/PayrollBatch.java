package day4_livecoding.class_problems;

public class PayrollBatch {
    private String empId;
    private double salary;

    public PayrollBatch(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public String getEmpId() {
        return empId;
    }

    public double getSalary() {
        return salary;
    }

    public void printStatus() {
        System.out.println(empId + " | Final Salary: Rs " + salary);
    }

    public static void main(String[] args) {
        PayrollBatch[] employees = {
            new PayrollBatch("E-101", 40000),
            new PayrollBatch("E-102", 55000),
            new PayrollBatch("E-103", 62000),
            new PayrollBatch("E-104", 48000)
        };

        for (PayrollBatch emp : employees) {
            emp.raiseSalary(5000);
            emp.printStatus();
        }
    }
}
