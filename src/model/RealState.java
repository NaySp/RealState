package model;
import java.time.Month;

import model.*;

public class RealState{

    public static final int SIZE_BUILDING = 10; 
    public static final int SIZE_APARTMENT= 25;

    private Building[] buildings;
    private Apartment[] apartments;

    public RealState(){
        buildings = new Building[SIZE_BUILDING];
        apartments = new Apartment[SIZE_APARTMENT];
    }


    public Building[] getBuildings(){
        return buildings;
    }

    public Apartment[] getApartments(){
        return apartments;
    }

    public String addBuilding(String idBuilding, int numApartments, String address){
        String msj = "Algo salió mal, no pudo ser agregado.";

        Building newBuilding = new Building(idBuilding, numApartments, address);
        boolean isEmpty = false;

        if(numApartments == -1){
            msj = "Por favor utiliza números donde se requiere.";
        }else{
            for(int i = 0; i < SIZE_BUILDING && !isEmpty; i++){
                if(buildings[i] == null){
                    buildings[i] = newBuilding;
                    msj = "Nuevo edificio agregado. ";
                }
            }

        }
        return msj;
    }

    public int searchBuilding(String idBuilding){
        int pos = -1;
        boolean isFound = false;

        for(int i = 0; i < SIZE_BUILDING && isFound; i++){
            if(buildings[i] != null && buildings[i].getidBuilding().equalsIgnoreCase(idBuilding)){
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }   

    public String registerAptToBuilding(String idBuild, int numApt, int numRooms, int numBath, boolean hasBalcony, double monthRent){
        
        String msj = "";
        Apartment newApartment = new Apartment(numApt, numRooms, numBath, hasBalcony, monthRent);
        int posBuilding = searchBuilding(idBuild);

        if(numApt == -1 | numRooms == -1 | numBath ==-1 | monthRent == -1){
            msj = "Digita números donde se requieren, no escribas letras.";
        }else if(posBuilding != -1){
            msj = buildings[posBuilding].addApt(newApartment);
        }
        return msj;

    }


    


}