package edu.ucalgary.oop;
// GROUP 22
public class Inquirer {
    private final String FIRST_NAME;
    private final String LAST_NAME;
    private final String INFO;
    private final String SERVICES_PHONE;


    // Constructor
    public Inquirer(String FIRST_NAME, String LAST_NAME, String SERVICES_PHONE, String INFO){
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.INFO = INFO;
        this.SERVICES_PHONE = SERVICES_PHONE;
    }
    //Getters
    public String getFirstName() {
        return FIRST_NAME;
    }

    public String getLastName() {
        return LAST_NAME;
    }

    public String getInfo() {
        return INFO;
    }

    public String getServicesPhoneNum() {
        return SERVICES_PHONE;
    }




}
