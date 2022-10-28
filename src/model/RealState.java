package model;


import model.*;

public class RealState{

    public static final int SIZE_BUILDING = 10; 
    public static final int SIZE_APARTMENT= 25;
    public static final int SIZE_USER = 10;

    private Building[] buildings;
    private Apartment[] apartments;
    private User[] users;

    public RealState(){
        buildings = new Building[SIZE_BUILDING];
        apartments = new Apartment[SIZE_APARTMENT];
        users = new User[SIZE_USER];
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
        }
        else if(numApartments > SIZE_APARTMENT){
            msj = ("El numero de apartamentos no puede ser mayor a " + SIZE_APARTMENT);
        }
        else if(valId == -1){
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

        for(int i = 0; i < SIZE_BUILDING && !isFound; i++){
            if(buildings[i] != null){
                if(buildings[i].getidBuilding().equalsIgnoreCase(idBuildSearch)){
                    pos = i;
                    isFound = true;
                }
            }              
        }
        return pos;
    }   

    public String registerAptToBuilding(String idBuild, int numApt, int numRooms, int numBath, int balcony, double monthRent, String name, String ccType, String cc, String number, int typePhone, String nameAccount, String nameBank){
        
        String msj = "";
        int posBuilding = searchBuilding(idBuild);
        boolean isCreatedApto = false;
        boolean isCreated = false;
    
          
        int validateName = validateNameOwner(name);

        if(validateName == -1){
            msj = "El nombre de usuario ya está en uso.";
        }
        else if(numApt == -1 || numRooms == -1 || numBath ==-1 || balcony == -1 || typePhone == -1){
            msj = "Digita números donde se requieren, no escribas letras.";
        }
        else if(balcony != 1 && balcony != 2){
            msj = "Opcion de balcon invalida.";
        }
        else if( monthRent == -1){
            msj = "Digita un precio válido. Usando comas.";
        }
        else if(posBuilding == -1){
            msj = "El edificio al que deseas añadir apartamentos no existe.";           
        }
        else{
            int sizeApartmentBuilding = buildings[posBuilding].getNumApartments();

            for(int i = 0; i < sizeApartmentBuilding && !isCreatedApto; i++){
                if(buildings[posBuilding].apartments[i] == null ){
                    buildings[posBuilding].apartments[i] = new Apartment(numApt, numRooms, numBath, balcony, monthRent);
                    
                    for(int k = 0; k < SIZE_USER && !isCreated; k++){
                        if(users[k] == null){
                            users[k] = new Owner(name, ccType, cc, number, typePhone, nameAccount, nameBank);
                            users[k].apartments[0] = new Apartment(numApt, numRooms, numBath, balcony, monthRent);
                        }    

                        isCreated = true;
                        
                    }

                }    
                isCreatedApto = true;
                
                msj = "Apartamento añadido.";
                
            }
        }

        return msj;
    
    }


    

    public String registerOwner(String name, String ccType, String cc, String number, int typePhone, String nameAccount, String nameBank){
       String msj = "Algo salio mal.";
       boolean isCreated = false;
        
        int validateName = validateNameOwner(name);

        if(validateName == -1){
            msj = "El nombre de usuario ya está en uso.";
        }
        else if(typePhone == -1){
            msj = "Digita números donde se requieren, no escribas letras.";
        }
        else{
            for(int i = 0; i < SIZE_USER && !isCreated; i++){
                if(users[i] == null){
                    users[i] = new Owner(name, ccType, cc, number, typePhone, nameAccount, nameBank);
                    msj = "Dueño añadido con exito.";
                    isCreated = true;

                }
            }

        }

       return msj;

    }
    
    public int validateNameOwner(String name){
        int result = 0;
        boolean isFound = false;

        for(int i = 0; i < SIZE_USER && !isFound; i++){
            if(users[i] != null){ 
                if(users[i].getName().equalsIgnoreCase(name)){
                    result = -1;
                }
            }
        }

        return result;
    }

    public String registerTenant(String buildingToTenant, int apartmentToRent, String ccType, String cc, String nameTenant, String numberOfContact, int  numberContactType){
        String msj = "Algo ha salido mal :(.";
        boolean isCreateT = false;
        int sizeBuild = 0;
        int existApartment = 0;
        int freeApartment = 0;
        int posBuild = searchBuilding(buildingToTenant);
        if(posBuild == -1){
            msj = "El nombre del edificio no existe.";
        }
        else{
            sizeBuild = buildings[posBuild].getNumApartments();
            existApartment = validateApto(posBuild, apartmentToRent, sizeBuild);
            freeApartment = isFreeApto(posBuild, apartmentToRent, sizeBuild);

            if(numberContactType == -1 || apartmentToRent == -1){
                msj = "Digita números donde se requieren, no escribas letras.";
            }
            else if(freeApartment == -1){
                msj = "El apartamento está rentado";
            }
            else if(existApartment == -1){
                msj = "No existe ese numero de apartamento";
            }
            else{
                for(int i = 0; i < SIZE_USER && !isCreateT; i++){
                    if(users[i] == null){
                        users[i] = new Tenant(nameTenant, ccType, cc, numberOfContact, numberContactType);
                        buildings[posBuild].apartments[existApartment].setIsRented();
                        msj = "Arrendatario añadido con exito.";
                        isCreateT = true;
                    }
                }
            }

        }

        return msj;

    }

    public int validateApto(int buildingSearched, int numberSearched, int sizeBuild){
        int result = -1;
        boolean isApto = false;
        for(int i = 0; i < sizeBuild && !isApto; i++){ 
            if(buildings[buildingSearched].apartments[i] != null){ 
                if(buildings[buildingSearched].apartments[i].getnumApto() == numberSearched){ 
                    isApto = true;
                    result = i;
                }
            }
        }
        return result;
    }

        /**
     * @param numberSearched
     * @return
     */
    public int isFreeApto(int buildingSearched, int numberSearched, int sizeBuild){
        int isFree = 0;
        boolean isApto = false;
        
        for(int i = 0; i < sizeBuild && !isApto; i++){ 

            if(buildings[buildingSearched].apartments[i] != null){ 
                
                if(buildings[buildingSearched].apartments[i].getnumApto() == numberSearched){ 
                    if(buildings[buildingSearched].apartments[i].getIsRented() == true){
                        isFree = -1;
                    }
                    isApto = true;
                }
            }
        }
        return isFree;
    }

    public String consultAvailableAptos(String name){
        String msj = "Algo salio mal.";
        int num = 0;

        int posBuilding = searchBuilding(name);

        if(posBuilding == -1){
            msj = "El edificio no existe.";
        }
        else{ 

            int sizeApartmentBuilding = buildings[posBuilding].getNumApartments();

            for(int i = 0; i < sizeApartmentBuilding; i++ ){
                if(buildings[posBuilding].apartments[i] != null){
                    if(buildings[posBuilding].apartments[i].getIsRented() == false){
                        num++;
                    }
                }
            }

            msj = ("El numero de apartamentos libres en el edificio " + name + " es: " + num);
        }
        


        return msj;
    }

    public String consultAmountAptos(String name){
        String msj = "Algo salio mal.";
        double sum = 0;

        int posBuilding = searchBuilding(name);
        
        if(posBuilding == -1){
            msj = "El edificio no existe.";
        }
        else{ 
            int sizeApartmentBuilding = buildings[posBuilding].getNumApartments();

            for(int i = 0; i < sizeApartmentBuilding; i++){
                if(buildings[posBuilding].apartments[i] != null){
                    if(buildings[posBuilding].apartments[i].getIsRented() == true){ 
                        sum += buildings[posBuilding].apartments[i].getMontRent();
                    }
                }
            }

            msj = ("Del edificio " + name + " se espera una cantidad de " + sum + " pesos.");

        }

        return msj;
    }

}