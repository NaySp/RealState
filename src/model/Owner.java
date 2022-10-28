package model;

public class Owner extends User{
    private final int SIZE_APARTMENT = 25;

    private String nameAccount;
    private String nameBank;
    protected Apartment[] apartmentsOwner;

    public Owner(String name, String ccType, String cc, String number, int typePhone, String nameAccount, String nameBank){
        super(name,ccType, cc, number, typePhone);
        this.nameAccount = nameAccount;
        this.nameBank = nameBank;
        this. apartmentsOwner = new Apartment[SIZE_APARTMENT];
    }

    public String getnameAccount(){
        return nameAccount;
    }

    public String getnameBamk(){
        return nameBank;
    }



}