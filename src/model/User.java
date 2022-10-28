package model;

public abstract class User{

    private final int SIZE_APARTMENT = 25;
    private String name;
    private String ccType;
    private String cc;
    private String number;
    private TypePhone typePhone;
    protected Apartment[] apartments;

    public User(String name, String ccType, String cc, String number, int typePhone){
        this.name = name;
        this.cc = cc;
        this.ccType = ccType;
        this.number = number;
        this.apartments = new Apartment[SIZE_APARTMENT];

        switch(typePhone){
            case 1:
                this.typePhone = TypePhone.HOME;
                break;
            case 2:
                this.typePhone = TypePhone.OFFICE;
                break;
        
            case 3:
                this.typePhone = TypePhone.MOVIL;
                break;
            case 4:
                this.typePhone = TypePhone.FAMILY;
                break;
            case 5:
                this.typePhone = TypePhone.OTHER;
                break;

        }


    }

    public String getName(){
        return name; 
    }
    public void setName(String name){
        this.name = name;
    }

    public String getCc(){
        return cc;
    }
    public void setCc(String cc){
        this.cc = cc;
    }

    public String number(){
        return number;
    }
    public void setNumber(String number){
        this.number = number;
    }

    public int getType(){
		switch(typePhone){
			case HOME:
				return 1;

			case OFFICE:
				return 2;

			case MOVIL:
				return 3;

			case FAMILY:
				return 4;
            case OTHER:
                return 5;
				
			default:
				return 0;	
		}
	}




}