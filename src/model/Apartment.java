package model;

public class Apartment{

    protected int numApt;
    protected int numRooms;
    protected int numBath;
    protected boolean hasBalcony;
    protected double monthRent;
    protected boolean isRented;


    public Apartment(int numApt, int numRooms, int numBath, int hasBalcony, double monthRent){
        this.numApt = numApt;
        this.numRooms = numRooms;
        this.numBath = numBath;
        this.isRented = false;

        if(hasBalcony == 1){
            this.hasBalcony = true;
        }else if(hasBalcony == 2){
            this.hasBalcony = false;

        }
        this.monthRent = monthRent;
    }

    public int getnumApto(){
        return this.numApt;
    }

    public void setIsRented(){
        this.isRented = !isRented;
    }
    
    public boolean getIsRented(){
        return this.isRented;
    }

    public double getMontRent(){
        return this.monthRent;
    }

}