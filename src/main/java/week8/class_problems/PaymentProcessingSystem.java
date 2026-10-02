package main.java.week8.class_problems;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

interface PaymentMethod {
    boolean processPayment(double amount);
    String getMethodName();
}

class CreditCardPayment implements PaymentMethod {
    private boolean shouldSucceed;

    public CreditCardPayment(boolean shouldSucceed) {
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public boolean processPayment(double amount) {
        return shouldSucceed;
    }

    @Override
    public String getMethodName() { return "Credit Card"; }
}

class PayPalPayment implements PaymentMethod {
    private boolean shouldSucceed;

    public PayPalPayment(boolean shouldSucceed) {
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public boolean processPayment(double amount) {
        return shouldSucceed;
    }

    @Override
    public String getMethodName() { return "PayPal"; }
}

class Order {
    private Customer customer;
    private List<Product> items = new ArrayList<>();
    private String status = "Pending";

    public Order(Customer customer) {
        this.customer = customer;
        System.out.println("Order created for Customer " + customer.getName() + ".");
    }

    public void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(product);
        }
    }

    public void processPayment(PaymentMethod method) {
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        System.out.println("Payment initiated via " + method.getMethodName() + " for Order " + customer.getName() + ".");
        boolean success = method.processPayment(calculateTotal());

        if (success) {
            status = "Paid";
            System.out.println("Payment for Order " + customer.getName() + " successful. Order status: Paid.");
        } else {
            status = "Pending";
            System.out.println("Payment for Order " + customer.getName() + " failed. Order status: Pending.");
        }
    }

    private double calculateTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public String getStatus() { return status; }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        Customer custX = new Customer("X");
        Customer custY = new Customer("Y");
        Customer custZ = new Customer("Z");

        Product prodA = new Product("Product A", 20.0);
        Product prodB = new Product("Product B", 10.0);
        Product prodC = new Product("Product C", 15.0);

        Order orderX = new Order(custX);
        orderX.addProduct(prodA, 2);
        orderX.addProduct(prodB, 1);
        orderX.processPayment(new CreditCardPayment(true));

        Order orderY = new Order(custY);
        orderY.processPayment(new CreditCardPayment(true));

        Order orderZ = new Order(custZ);
        orderZ.addProduct(prodC, 1);
        orderZ.processPayment(new PayPalPayment(false));
    }
}