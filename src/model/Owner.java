package model;

public abstract class Owner extends User{

    private String nameAccount;
    private String nameBank;

    public Owner(String name, String cc, String number, int typePhone, String nameAccount, String nameBank){
        super(name,cc, number, typePhone);
        this.nameAccount = nameAccount;
        this.nameBank = nameBank;
    }

    public String getnameAccount(){
        return nameAccount;
    }

    public String getnameBamk(){
        return nameBank;
    }



}