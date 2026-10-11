package main.java.week10.class_problems;

import java.util.HashMap;
import java.util.Map;

abstract class Account {
    protected String id;
    protected double balance;

    public Account(String id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public abstract void withdraw(double amount);

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 1000.0;

    public SavingsAccount(String id, double initialBalance) {
        super(id, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < MIN_BALANCE) {
            System.out.printf("%s rejected: minimum balance %.0f\n", id, MIN_BALANCE);
        } else {
            balance -= amount;
            System.out.printf("%s balance %.0f\n", id, balance);
        }
    }
}

class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount(String id, double initialBalance) {
        super(id, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < -OVERDRAFT_LIMIT) {
            System.out.printf("%s rejected: overdraft limit %.0f\n", id, OVERDRAFT_LIMIT);
        } else {
            balance -= amount;
            System.out.printf("%s balance %.0f\n", id, balance);
        }
    }
}

public class BankAccountWithdrawalSystem {

    public static void main(String[] args) {
        Map<String, Account> accounts = new HashMap<>();

        // Simulated operations from problem example
        String[][] operations = {
            {"Savings", "S1", "5000"},
            {"WITHDRAW", "S1", "4500"},
            {"Current", "C1", "2000"},
            {"WITHDRAW", "C1", "6000"},
            {"WITHDRAW", "S1", "3000"},
            {"WITHDRAW", "C1", "2000"}
        };

        for (String[] op : operations) {
            if (op[0].equals("Savings")) {
                String id = op[1];
                double initBal = Double.parseDouble(op[2]);
                accounts.put(id, new SavingsAccount(id, initBal));
            } else if (op[0].equals("Current")) {
                String id = op[1];
                double initBal = Double.parseDouble(op[2]);
                accounts.put(id, new CurrentAccount(id, initBal));
            } else if (op[0].equals("WITHDRAW")) {
                String id = op[1];
                double amount = Double.parseDouble(op[2]);
                Account acc = accounts.get(id);
                if (acc != null) {
                    acc.withdraw(amount);
                } else {
                    System.out.println("Account not found");
                }
            }
        }
    }
}