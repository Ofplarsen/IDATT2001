package edu.ntnu.oflarsen.idatt2001.oblig3.TicketTypes;

import edu.ntnu.oflarsen.idatt2001.oblig3.Ticket;

public class SittingTicket extends Ticket {
    private final int row;
    private final int place;

    public SittingTicket(String tribuneName, int price, int row, int place) {
        super(tribuneName, price);

        if(row<0||place<0){
            throw new IllegalArgumentException("Nor row or place can be negative: \n" + "Row: " + row + ", Place: " + place);
        }
        this.row = row;
        this.place = place;
    }

    public int getRow() {
        return row;
    }

    public int getPlace() {
        return place;
    }

    @Override
    public String toString() {
        String res = super.toString();
        return res += "Row=" + row + ", Place=" + place;
    }
}
