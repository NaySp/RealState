package model;

public class Apartment{

    protected int numApt;
    protected int numRooms;
    protected int numBath;
    protected boolean hasBalcony;
    protected double monthRent;
    private Building building;


    public Apartment(int numApt, int numRooms, int numBath, String hasBalcony, double monthRent){
        this.numApt = numApt;
        this.numRooms = numRooms;
        this.numBath = numBath;

        if(hasBalcony.equalsIgnoreCase("si")){
            this.hasBalcony = true;
        }else if(hasBalcony.equalsIgnoreCase("no")){
            this.hasBalcony = false;

        }
        this.monthRent = monthRent;
        this.monthRent = monthRent;
    }

    public Building getBuilding(){
        return building;
    }

    


    

}