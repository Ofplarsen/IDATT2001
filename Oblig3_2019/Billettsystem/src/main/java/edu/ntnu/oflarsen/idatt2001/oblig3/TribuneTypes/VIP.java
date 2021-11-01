package edu.ntnu.oflarsen.idatt2001.oblig3.TribuneTypes;

import edu.ntnu.oflarsen.idatt2001.oblig3.Ticket;
import edu.ntnu.oflarsen.idatt2001.oblig3.Tribune;

public class VIP extends Tribune {
    private String[][] spectator; //tilskuere: antall rader * antall plasser pr rad

    public VIP(String tribuneName, int capacity, int price) {
        super(tribuneName, capacity, price);
    }

    @Override
    public int findNumberOfSoldTickets() {
        int sum = 0;
        return sum;
    }

    @Override
    public int findIncome() {
        return 0;
    }

    @Override
    public Ticket[] buyTicket(int numberOfTickets) {
        return new Ticket[0];
    }

    @Override
    public Ticket[] buyTicket(String[] namesOfTicketHolders) {
        return new Ticket[0];
    }
}
