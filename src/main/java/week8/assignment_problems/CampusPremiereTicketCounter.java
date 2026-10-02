package main.java.week8.assignment_problems;

abstract class Ticket {
    private String seatNumber;
    private double basePrice;

    public Ticket(String seatNumber, double basePrice) {
        this.seatNumber = seatNumber;
        this.basePrice = basePrice;
    }

    public String getSeatNumber() { return seatNumber; }
    public double getBasePrice() { return basePrice; }

    public abstract double calculatePrice();
    public abstract String getCategory();
}

class StandardTicket extends Ticket {
    public StandardTicket(String seatNumber) {
        super(seatNumber, 150.0);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice();
    }

    @Override
    public String getCategory() { return "Standard"; }
}

class VipTicket extends Ticket {
    public VipTicket(String seatNumber) {
        super(seatNumber, 250.0);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice() + 50.0; // Includes snack pass
    }

    @Override
    public String getCategory() { return "VIP"; }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}

class TicketCounter {
    private String showName;
    private int availableSeats;

    public TicketCounter(String showName, int availableSeats) {
        this.showName = showName;
        this.availableSeats = availableSeats;
    }

    public void bookTicket(Customer customer, Ticket ticket) {
        if (availableSeats <= 0) {
            System.out.println("Housefull! No seats available for " + showName + ".");
            return;
        }
        availableSeats--;
        System.out.printf("%s ticket booked for %s (Seat %s). Total charge: $%.2f. Seats remaining: %d.\n",
                ticket.getCategory(), customer.getName(), ticket.getSeatNumber(), ticket.calculatePrice(), availableSeats);
    }
}

public class CampusPremiereTicketCounter {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter("Campus Movie Premiere", 2);

        Customer c1 = new Customer("Aarav");
        Customer c2 = new Customer("Dia");
        Customer c3 = new Customer("Kabir");

        counter.bookTicket(c1, new StandardTicket("A1"));
        counter.bookTicket(c2, new VipTicket("V1"));
        counter.bookTicket(c3, new StandardTicket("A2"));
    }
}