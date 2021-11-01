package edu.ntnu.oflarsen.idatt2001.oblig3.TribuneTypes;

import edu.ntnu.oflarsen.idatt2001.oblig3.Ticket;
import edu.ntnu.oflarsen.idatt2001.oblig3.TicketTypes.StandingTicket;
import edu.ntnu.oflarsen.idatt2001.oblig3.Tribune;

public class Stand extends Tribune {
    private int noSoldTickets;

    public Stand(String tribuneName, int capacity, int price) {
        super(tribuneName, capacity, price);
    }

    @Override
    public Ticket[] buyTicket(int numberOfTickets) {
        if(findNumberOfSoldTickets()+numberOfTickets > getCapacity()){
            throw new IllegalArgumentException("The tribune has reached it's max capacity");
        }
        Ticket[] tickets = new Ticket[numberOfTickets];
        for (int i = 0; i < tickets.length; i++){
            tickets[i] = new StandingTicket("Stand", getPrice());
        }
        return tickets;
    }

    @Override
    public Ticket[] buyTicket(String[] namesOfTicketHolders) {
        if(findNumberOfSoldTickets()+namesOfTicketHolders.length > getCapacity()){
            throw new IllegalArgumentException("The tribune has reached it's max capacity");
        }
        Ticket[] tickets = new Ticket[namesOfTicketHolders.length];
        for (int i = 0; i < tickets.length; i++){
            tickets[i] = new StandingTicket("Stand", getPrice());
        }
        return tickets;
    }

    @Override
    public int findNumberOfSoldTickets() {
        return noSoldTickets;
    }

    @Override
    public int findIncome() {
        return noSoldTickets * getPrice();
    }
}
