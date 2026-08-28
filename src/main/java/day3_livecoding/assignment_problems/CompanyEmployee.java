package day3_livecoding.assignment_problems;

public class CompanyEmployee {
    private String empName;
    private double salary;
    private static String companyName = "Bright Horizon Technologies";
    private static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public String getEmpName() {
        return empName;
    }

    public double getSalary() {
        return salary;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        CompanyEmployee emp1 = new CompanyEmployee("Divya", 65000);
        CompanyEmployee emp2 = new CompanyEmployee("Arjun", 50000);
        CompanyEmployee emp3 = new CompanyEmployee("Rohan", 55000);

        if (emp1.getEmpName() != null && emp2.getEmpName() != null && emp3.getEmpName() != null) {
            CompanyEmployee.printCompanyInfo();
        }
    }
}