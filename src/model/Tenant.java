package model;

public abstract class Tenant extends User{

    private String eee;

    public Tenant(String name, String cc, String number,int typePhone,  String eee){
        super(name,cc, number, typePhone);
        this.eee = eee;
    }

    public String getEee(){
        return eee;
    }



}