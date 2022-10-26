package ui;

import model.User;
import model.Tenant;
import model.Owner;
import model.TypePhone;
import model.RealState;

import java.util.Scanner;

public class Main{

    private Scanner reader;
    private RealState realState;

    public Main(){
        this.reader = new Scanner(System.in);
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

                main.getReader().close();

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
		int option = 0;
		
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


        String msj;
        String idBuilding;
        String hasBalcony;
        String address;


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
                System.out.println("Escribe si tiene balcón o no.");
                hasBalcony = reader.next();
                System.out.println("Ingresa el valor mensual del arrendamiento: ");
                monthRent = validateDouble();
                msj = realState.registerAptToBuilding(idBuilding, numApt, numRooms, numBath, hasBalcony, monthRent);
                System.out.println(msj);

                break;

            case 3: 
                break;
            
            case 4: 
                break;
            
            case 5: 
                break;
            
            case 6: 
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

