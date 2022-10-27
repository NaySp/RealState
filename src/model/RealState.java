package model;


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
        int valId = validateidBuilding(idBuilding);

        if(numApartments == -1){
            msj = "Por favor utiliza números donde se requiere.";
        }else if(valId == -1){
            msj = "El nombre de edificio se encuentra actualmente en uso.";

        }
        else{
            for(int i = 0; i < SIZE_BUILDING && !isEmpty; i++){
                if(buildings[i] == null){
                    buildings[i] = new Building(idBuilding, numApartments, address);
                    msj = "Nuevo edificio agregado. ";
                    isEmpty = true;
                }
            }

        }
        return msj;
    }


    public int validateidBuilding(String id){
		int verifier = 0;
		boolean isFoundedName = false;
		for(int i = 0; i < SIZE_BUILDING && !isFoundedName; i++){
			if(buildings[i] != null){
				if(buildings[i].getidBuilding().equalsIgnoreCase(id)){
					verifier = -1;
					isFoundedName = true;
				}
			}
		}
		return verifier;
	}


    public int searchBuilding(String idBuildSearch){

        int pos = -1;
        boolean isFound = false;

        for(int i = 0; i < SIZE_BUILDING && isFound; i++){
            if(buildings[i] != null){
                if(buildings[i].getidBuilding().equalsIgnoreCase(idBuildSearch)){
                    pos = i;
                    isFound = true;
                }
            }              
        }
        return pos;
    }   

    public String registerAptToBuilding(String idBuild, int numApt, int numRooms, int numBath, String balcony, double monthRent){
        
        String msj = "";
        int posBuilding = searchBuilding(idBuild);
        boolean isCreated = false;
    
        
        if(numApt == -1 | numRooms == -1 | numBath ==-1){
            msj = "Digita números donde se requieren, no escribas letras.";
        }
        else if( monthRent == -1){
            msj = "Digita un precio válido. Usando comas.";
        }
        else if(posBuilding == -1){
            msj = "El edificio al que deseas añadir apartamentos no existe.";           
        }
        else{
            for(int i = 0; i < SIZE_APARTMENT && !isCreated; i++){
                if(buildings[posBuilding].apartments[i] == null ){
                    buildings[posBuilding].apartments[i] = new Apartment(numApt, numRooms, numBath, balcony, monthRent);
                    isCreated = true;
                    System.out.println("Apartamento añadido");
                }
            }
        }
        return msj;

    }
    

}