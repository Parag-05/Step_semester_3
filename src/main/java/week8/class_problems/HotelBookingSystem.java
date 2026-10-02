package main.java.week8.class_problems;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
}

abstract class Room {
    private String roomNumber;
    private double baseRate;

    public Room(String roomNumber, double baseRate) {
        this.roomNumber = roomNumber;
        this.baseRate = baseRate;
    }

    public String getRoomNumber() { return roomNumber; }
    public double getBaseRate() { return baseRate; }

    public abstract String getCategoryName();
    public abstract double calculatePrice(int nights);
}

class StandardRoom extends Room {
    public StandardRoom(String roomNumber) {
        super(roomNumber, 100.0);
    }

    @Override
    public String getCategoryName() { return "Standard Room"; }

    @Override
    public double calculatePrice(int nights) {
        return getBaseRate() * nights;
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(String roomNumber) {
        super(roomNumber, 150.0);
    }

    @Override
    public String getCategoryName() { return "Deluxe Room"; }

    @Override
    public double calculatePrice(int nights) {
        return getBaseRate() * nights;
    }
}

class Reservation {
    private static List<Reservation> activeReservations = new ArrayList<>();

    private Customer customer;
    private Room room;
    private int startDay;
    private int endDay;
    private boolean active;

    public Reservation(Customer customer, Room room, int startDay, int endDay) {
        this.customer = customer;
        this.room = room;
        this.startDay = startDay;
        this.endDay = endDay;
        this.active = true;
    }

    public static boolean checkAvailability(Room room, int startDay, int endDay) {
        for (Reservation res : activeReservations) {
            if (res.active && res.room.getRoomNumber().equals(room.getRoomNumber())) {
                if (startDay < res.endDay && endDay > res.startDay) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Reservation reserve(Customer customer, Room room, int startDay, int endDay, String month) {
        if (!checkAvailability(room, startDay, endDay)) {
            System.out.println(room.getCategoryName() + " " + room.getRoomNumber() + " is not available from " + month + " " + startDay + " to " + month + " " + endDay + ".");
            return null;
        }
        Reservation res = new Reservation(customer, room, startDay, endDay);
        activeReservations.add(res);
        double price = room.calculatePrice(endDay - startDay);
        System.out.println("Reservation confirmed for " + customer.getName() + ", " + room.getCategoryName() + " " + room.getRoomNumber() + " (" + month + " " + startDay + "-" + endDay + "). Price: $" + (int)price + ".");
        return res;
    }

    public void cancel(String month) {
        if (active) {
            active = false;
            System.out.println("Reservation for " + customer.getName() + ", " + room.getCategoryName() + " " + room.getRoomNumber() + " (" + month + " " + startDay + "-" + endDay + ") cancelled successfully.");
        }
    }
}

public class HotelBookingSystem {
    public static void main(String[] args) {
        Customer custA = new Customer("A", "Customer A");
        Customer custB = new Customer("B", "Customer B");
        Customer custC = new Customer("C", "Customer C");

        StandardRoom room101 = new StandardRoom("101");
        DeluxeRoom room201 = new DeluxeRoom("201");

        if (Reservation.checkAvailability(room101, 1, 5)) {
            System.out.println("Standard Room 101 is available from Jan 1 to Jan 5.");
        }

        Reservation resA = Reservation.reserve(custA, room101, 1, 5, "Jan");
        Reservation resB = Reservation.reserve(custB, room101, 3, 7, "Jan");

        if (resA != null) {
            resA.cancel("Jan");
        }

        Reservation resC = Reservation.reserve(custC, room201, 10, 12, "Feb");
    }
}