package main.java.week10.class_problems;

import java.util.ArrayList;
import java.util.List;

abstract class Staff {
    protected String name;
    protected String type;

    public Staff(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Payslip[name=%s, type=%s, pay=%.0f]", name, type, calculatePay());
    }
}

class FullTimeStaff extends Staff {
    private double salary;

    public FullTimeStaff(String name, double salary) {
        super(name, "FullTime");
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        return salary;
    }
}

class PartTimeStaff extends Staff {
    private double hours;
    private double rate;

    public PartTimeStaff(String name, double hours, double rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        return hours * rate;
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class PayrollRegisterSystem {

    public static void main(String[] args) {
        List<Staff> staffList = new ArrayList<>();

        // Simulated operation input
        String[][] inputs = {
            {"FullTime", "Asha", "50000"},
            {"PartTime", "Ravi", "80", "300"},
            {"Intern", "Neha", "15000"}
        };

        for (String[] record : inputs) {
            String type = record[0];
            String name = record[1];

            if (type.equals("FullTime")) {
                double salary = Double.parseDouble(record[2]);
                staffList.add(new FullTimeStaff(name, salary));
            } else if (type.equals("PartTime")) {
                double hours = Double.parseDouble(record[2]);
                double rate = Double.parseDouble(record[3]);
                staffList.add(new PartTimeStaff(name, hours, rate));
            } else if (type.equals("Intern")) {
                double stipend = Double.parseDouble(record[2]);
                staffList.add(new InternStaff(name, stipend));
            }
        }

        double totalPay = 0;
        String topEarnerName = "";
        double maxPay = -1;

        for (Staff s : staffList) {
            System.out.println(s);
            double pay = s.calculatePay();
            totalPay += pay;
            if (pay > maxPay) {
                maxPay = pay;
                topEarnerName = s.getName();
            }
        }

        System.out.printf("Total %.0f\n", totalPay);
        System.out.printf("top earner %s\n", topEarnerName);
    }
}