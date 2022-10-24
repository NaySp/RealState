package model;

public class Apartment{

    protected int numApt;
    protected int numRooms;
    protected int numBath;
    protected boolean hasBalcony;
    protected double monthRent;


    public Apartment(int numApt, int numRooms, int numBath, boolean hasBalcony, double monthRent){
        this.numApt = numApt;
        this.numRooms = numRooms;
        this.numBath = numBath;
        this.hasBalcony = hasBalcony;

        this.monthRent = monthRent;
    }

    

}