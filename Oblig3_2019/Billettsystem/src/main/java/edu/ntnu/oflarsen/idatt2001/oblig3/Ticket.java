package edu.ntnu.oflarsen.idatt2001.oblig3;

public abstract class Ticket {
    private final String tribuneName;
    private final int price;

    public Ticket(String tribuneName, int price){
        if(tribuneName == null || tribuneName.trim().equals("")){
            throw new IllegalArgumentException("Tribune name must be given");
        }
        this.tribuneName = tribuneName;
        this.price = price;
    }

    public String getTribuneName() {
        return tribuneName;
    }

    public int getPrice() {
        return price;
    }

    public String toString(){
        return "Tribune: " + tribuneName + ", Pris: " + price;
    }
}
