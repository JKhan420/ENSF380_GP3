package edu.ucalgary.oop;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class ReliefService {
    // FIELDS
    private Inquirer inquirer;
    private DisasterVictim missingPerson;
    private String dateOfInquiry;
    private String infoProvided;
    private Location lastKnownLocation;

    // CONSTRUCTOR ReliefService also checks for valid Date input
    public ReliefService(Inquirer inquirer, DisasterVictim missingPerson, String dateOfInquiry, String infoProvided, Location lastKnownLocation) {
        this.inquirer = inquirer;
        this.missingPerson = missingPerson;
        try {
            LocalDate.parse(dateOfInquiry, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid entry date format. Please use YYYY-MM-DD.");
            return;
        }
        this.dateOfInquiry = dateOfInquiry;
        this.infoProvided = infoProvided;
        this.lastKnownLocation = lastKnownLocation;
    }
    // GETTERS

    // returns Inquirer inquirer
    public Inquirer getInquirer() {
        return inquirer;
    }
    // returns DisasterVictim missingPerson
    public DisasterVictim getMissingPerson() {
        return missingPerson;
    }
    // returns String dateOfInquiry
    public String getDateOfInquiry() {
        return dateOfInquiry;
    }
    // returns String infoProvided
    public String getInfoProvided() {
        return infoProvided;
    } 
    // returns Location lastKnownLocation
    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }

    // SETTERS

    // Takes in Inquirer param and sets it to inquirer
    public void setInquirer(Inquirer inquirer) {
        this.inquirer = inquirer;
    }
    // Takes in DisasterVictim param and sets it to missingPerson
    public void setMissingPerson(DisasterVictim missingPerson) {
        this.missingPerson = missingPerson;
    }
    // Takes in String param and sets it to dateOfInquiry also checks for valid input
    public void setDateOfInquiry(String dateOfInquiry) {
        try {
            LocalDate.parse(dateOfInquiry, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid entry date format. Please use YYYY-MM-DD.");
            return;
        }
        this.dateOfInquiry = dateOfInquiry;
    } 
    // Takes in String param and sets it to infoProvided
    public void setInfoProvided(String infoProvided) {
        this.infoProvided = infoProvided;
    }   
    // Takes in Location param and sets it to lastKnownLocation
    public void setLastKnownLocation(Location lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }
    
    public String getLogDetails() {
        return "Inquirer: " + this.inquirer.getFullName() + ", Missing Person: " + missingPerson.getName() + ", Date of Inquiry: " + dateOfInquiry + ", Info Provided: " + infoProvided + ", Last Known Location: " + lastKnownLocation.getAddress();
    }
}