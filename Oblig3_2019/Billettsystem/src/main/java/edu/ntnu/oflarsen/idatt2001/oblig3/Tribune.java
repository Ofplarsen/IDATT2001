package edu.ntnu.oflarsen.idatt2001.oblig3;

public abstract class Tribune {
    private final String tribuneName;
    private final int capacity;
    private final int price;

    public Tribune(String tribuneName, int capacity, int price) {
        this.tribuneName = tribuneName;
        this.capacity = capacity;
        this.price = price;
    }

    public abstract int findNumberOfSoldTickets();

    public abstract int findIncome();

    public abstract Ticket[] buyTicket(int numberOfTickets);

    public abstract Ticket[] buyTicket(String[] namesOfTicketHolders);

    public String getTribuneName() {
        return tribuneName;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }
}
