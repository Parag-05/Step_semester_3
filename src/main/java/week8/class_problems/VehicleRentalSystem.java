package main.java.week8.class_problems;

import java.util.ArrayList;

abstract class Vehicle {
    private String vehicleId;
    private String vehicleName;
    private boolean available;

    public Vehicle(String vehicleId, String vehicleName) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.available = true;
    }

    public String getVehicleId() { return vehicleId; }
    public String getVehicleName() { return vehicleName; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public abstract double calculateRentalCharge(int days);
}

class Sedan extends Vehicle {
    public Sedan(String vehicleId, String vehicleName) {
        super(vehicleId, vehicleName);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return days * 50.0;
    }
}

class SUV extends Vehicle {
    public SUV(String vehicleId, String vehicleName) {
        super(vehicleId, vehicleName);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return days * 70.0;
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleId, String vehicleName) {
        super(vehicleId, vehicleName);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return days * 100.0;
    }
}

class Customer {
    private int customerId;
    private String customerName;

    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    public int getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
}

class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private int days;
    private double charge;

    public Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.days = days;
        this.charge = vehicle.calculateRentalCharge(days);
    }

    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }
    public double getCharge() { return charge; }
}

class RentalSystem {
    private ArrayList<Rental> rentals = new ArrayList<>();

    public void rentVehicle(Vehicle vehicle, Customer customer, int days) {
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getVehicleName() + " is currently unavailable.");
            return;
        }

        Rental rental = new Rental(vehicle, customer, days);
        rentals.add(rental);
        vehicle.setAvailable(false);

        System.out.println(vehicle.getVehicleName() + " rented successfully by " + customer.getCustomerName() + ". Rental charge: $" + (int)rental.getCharge());
    }

    public void returnVehicle(Vehicle vehicle, Customer customer) {
        for (Rental rental : rentals) {
            if (rental.getVehicle() == vehicle && rental.getCustomer() == customer) {
                vehicle.setAvailable(true);
                rentals.remove(rental);
                System.out.println(vehicle.getVehicleName() + " returned by " + customer.getCustomerName());
                return;
            }
        }
        System.out.println("No active rental found.");
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();

        Vehicle sedanA = new Sedan("S101", "Sedan A");
        Vehicle suvB = new SUV("SUV101", "SUV B");

        Customer customer1 = new Customer(1, "Customer 1");
        Customer customer2 = new Customer(2, "Customer 2");
        Customer customer3 = new Customer(3, "Customer 3");

        system.rentVehicle(sedanA, customer1, 3);
        system.rentVehicle(sedanA, customer2, 2);
        system.returnVehicle(sedanA, customer1);
        system.rentVehicle(suvB, customer3, 5);
    }
}