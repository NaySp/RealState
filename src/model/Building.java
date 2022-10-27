package model;

public class Building{

    public static final int SIZE_APARTMENT = 25;



    private String idBuilding;
    private int numApartments;
    private String address;
    
    protected Apartment[] apartments;

    public Building(String idBuilding, int numApartments, String address){
        this.idBuilding = idBuilding;
        this.numApartments = numApartments;
        this.address = address;
        apartments = new Apartment[numApartments];
        
    }

    public String getidBuilding(){
        return this.idBuilding;
    }


    public String addApt(Apartment apartment){
        String msj = "No se pudo agragar el apartamento. ";
        boolean isEmpty = false;
        for(int i = 0; i < SIZE_APARTMENT && !isEmpty; i++){
            if(apartments[i] == null){
                apartments[i] = apartment;
                isEmpty =true;
                msj = "Nuevo apartamento agregado.";
            }
        }
        return msj;
    }

    public Apartment[] getApartments(){
        return apartments;
    }

   


}