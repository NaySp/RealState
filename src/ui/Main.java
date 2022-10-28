package ui;
import model.*;
import java.util.Scanner;


public class Main{

    private Scanner reader;
    private RealState realState;

    public Main(){
        reader = new Scanner(System.in);
        realState = new RealState();
    }
    
    public RealState getRealState(){
        return realState;
    }
    
    public Scanner getReader(){
        return reader;
    }

    public static void main(String[] args){
        Main main = new Main();
		
        int option = 0;

        do{
            option = main.getOptionShowMenu();
            main.executeOption(option);

        }while(option !=0);

    }

    /** 
	 * This method shows to the user what he can do in the real state
	 * and save the answer as an int
	 * @return int
	 */
	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println(" ||| :} BIENVENIDO A INMOBILIARIA Sp {: ||| ");
		System.out.println(
				"1. Registrar edificio. \n" +
				"2. Registrar apartamento a un edificio. \n"+
				"3. Registrar información del dueño del apartamento. \n"+
				"4. Registrar información del arrendatario. \n"+
				"5. Consultar apartamentos disponibles. \n"+
				"6. Consultar valor mensual de apartamentos alquilados en un edificio . \n"+
				"7. Consultar por apartamento en particular disponible. \n"+
				"8. Consultar cuantos apartamentos tiene un dueño. \n"+
				"9. Valor total por concepto de arrendamiento que recibe el propietario. \n"+
				"0. Exit. ");
		option = reader.nextInt(); 

		return option; 
	}

    public int validateInt(){
		int option = -1;
		
		if(reader.hasNextInt()){
			option = reader.nextInt();
		}
		else{
			reader.next();
			option = -1;
		}

		return option;
	}

    public double validateDouble(){
        double option = 0.0;

        if(reader.hasNextDouble()){
            option = reader.nextDouble();
        }else{
            reader.next();
            option = -1;
        }
        return option;
    }




    public void executeOption(int option){


        int numApt;
        int numRooms;
        int numBath;
        int numApartments;

        double monthRent;

        String nameOwner;
        String ccTypeOwner;
        String ccOwner;
        String numberIdOwner;
        int typePhoneOwner; 
        String nameAccountOwner;
        String nameBankOwner;



        String msj;
        String idBuilding;
        int hasBalcony;
        String address;

        String buildingToTenant;
        int apartmentToRent;
        String ccTypeTenant;
        String ccTenant;
        String nameTenant;
        String numberOfContact;
        int numberContactType;

        String nameToAvailable;


		switch(option){
            case 1: 
                System.out.println(" > Registro de edificio: ");
                System.out.println(" Escribe un nombre de indentificación para el edificio: ");
                idBuilding = reader.next();
                System.out.println("Escribe el número de apartamentos que tendrá este edificio: ");
                numApartments = validateInt();
                System.out.println("Escribe la dirección del edificio: ");
                address = reader.next();
                msj = realState.addBuilding(idBuilding, numApartments, address);
                System.out.println(msj);

                break;

            case 2: 
                System.out.println(" > Registro de apartamento a edificio: ");
                System.out.println("Escribe el nombre del edificio al que registraras apartamento: ");
                idBuilding = reader.next();
                System.out.println("Digita un número de identificación para el apartamento: ");
                numApt = validateInt();
                System.out.println("Digita el número de cuartos:");
                numRooms = validateInt();
                System.out.println("Digita el número de baños: ");
                numBath = validateInt();

                System.out.println("Escribe si tiene balcón: \n" +
                "1. SI. \n" +
                "2. NO.");
                hasBalcony = validateInt();
                
                System.out.println("Ingresa el valor mensual del arrendamiento: ");
                monthRent = validateDouble();

                
                System.out.println("Escriba el nombre del dueño:");
                nameOwner = reader.next();
                System.out.println("Escriba el tipo de documento del dueño:");
                ccTypeOwner = reader.next();
                System.out.println("Escriba el documento:");
                ccOwner = reader.next();
                System.out.println("Digite el numero de contacto del dueño:");
                numberIdOwner = reader.next();
                System.out.println("Digite el tipo de telefono: \n" +
                "1. HOME. \n" +
                "2. OFFICE. \n" +
                "3. MOVIL. \n" +
                "4. FAMILY. \n" +
                "5. OTHER.");
                typePhoneOwner = validateInt();
                System.out.println("Digite el numero de la cuenta bancaria del dueño:");
                nameAccountOwner = reader.next();
                System.out.println("Ecriba el nombre del banco:");
                nameBankOwner = reader.next();


                msj = realState.registerAptToBuilding(idBuilding, numApt, numRooms, numBath, hasBalcony, monthRent, nameOwner, ccTypeOwner, ccOwner, numberIdOwner, typePhoneOwner, nameAccountOwner, nameBankOwner);
                System.out.println(msj);

                break;

            case 3: 
                System.out.println("Escriba el nombre del dueño:");
                nameOwner = reader.next();
                System.out.println("Escriba el tipo de documento del dueño:");
                ccTypeOwner = reader.next();
                System.out.println("Escriba el documento:");
                ccOwner = reader.next();
                System.out.println("Digite el numero de contacto del dueño:");
                numberIdOwner = reader.next();
                System.out.println("Digite el tipo de telefono: \n" +
                "1. HOME. \n" +
                "2. OFFICE. \n" +
                "3. MOVIL. \n" +
                "4. FAMILY. \n" +
                "5. OTHER.");
                typePhoneOwner = validateInt();
                System.out.println("Digite el numero de la cuenta bancaria del dueño:");
                nameAccountOwner = reader.next();
                System.out.println("Ecriba el nombre del banco:");
                nameBankOwner = reader.next();


                msj = realState.registerOwner(nameOwner, ccTypeOwner, ccOwner, numberIdOwner, typePhoneOwner, nameAccountOwner, nameBankOwner);
                System.out.println(msj);
                break;
            
            case 4: 
                System.out.println("Escriba el edificio en el que desea alquilar: ");
                buildingToTenant = reader.next();
                System.out.println("Escriba el numero del apartamento:");
                apartmentToRent = validateInt();
                System.out.println("Escriba el tipo de documento del arrendatario:");
                ccTypeTenant = reader.next();
                System.out.println("Digite el numero de documento:");
                ccTenant = reader.next();
                System.out.println("Escriba el nombre del arrendatario:");
                nameTenant = reader.next();
                System.out.println("Digite el numero de contacto del arrendatario:");
                numberOfContact= reader.next();
                System.out.println("Digite el tipo de telefono: \n" +
                "1. HOME. \n" +
                "2. OFFICE. \n" +
                "3. MOVIL. \n" +
                "4. FAMILY. \n" +
                "5. OTHER.");
                numberContactType = validateInt();


                msj = realState.registerTenant(buildingToTenant, apartmentToRent, ccTypeTenant, ccTenant, nameTenant, numberOfContact, numberContactType);
                System.out.println(msj);
                break;
            
            case 5: 
                System.out.println("Escriba el nombre del edificio a consultar:");
                nameToAvailable = reader.next();

                msj = realState.consultAvailableAptos(nameToAvailable);
                System.out.println(msj);

                break;
            
            case 6: 
            
            System.out.println("Escriba el nombre del edificio a consultar:");
            nameToAvailable = reader.next();

            msj = realState.consultAmountAptos(nameToAvailable);
            System.out.println(msj);
                break;

            case 7: 
                break;
            
            case 8: 
                break;
                
            case 9: 
                break;

            case 0:
                System.out.println("Vuelve pronto :) ");
                break;

            default:
                System.out.println("ups, opcion invalida :( ");
                break;
        } 
    }
}

