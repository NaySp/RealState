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
        boolean isEmpty = false;

        if(numApartments == -1){
            msj = "Por favor utiliza números donde se requiere.";
        }else{
            for(int i = 0; i < SIZE_BUILDING && !isEmpty; i++){
                if(buildings[i] == null){
                    new Building(idBuilding, numApartments, address);
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

    public String registerAptToBuilding(String idBuild, int numApt, int numRooms, int numBath, String balcony, double monthRent){
        
        
        String msj = "";
        int posBuilding = searchBuilding(idBuild);
        boolean createApt = false;
        

        if(numApt == -1 | numRooms == -1 | numBath ==-1){
            msj = "Digita números donde se requieren, no escribas letras.";
        }else if( monthRent == -1){
            msj = "Digita un precio válido. Usa puntos y/o comas.";
        }else if(posBuilding != -1){
            msj = "El edificio al que deseas añadir apartamentos no existe.";           
        }else if( !balcony.equalsIgnoreCase("si") || !balcony.equalsIgnoreCase("no")){
            msj = "Escribe si o no.";            
        }
        else{
            for(int i = 0; i < SIZE_APARTMENT && !createApt; i++){
                if(buildings[posBuilding].apartments[i] == null){
                    buildings[posBuilding].apartments[i] = new Apartment(numApt, numRooms, numBath, balcony, monthRent);
                }
            }


        }
        return msj;

    }
    

}