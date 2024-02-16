package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DisasterVictim {
    // FIELDS
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String comments;
    private final int ASSIGNED_SOCIAL_ID; 
    private MedicalRecord[] medicalRecords;
    private Supply[] personalBelongings;
    private FamilyRelation[] familyConnections;
    private final String ENTRY_DATE;
    private String gender;
    private static int instance_count = 0; //keep track of the amount of instances to ensure a unqiue assigned social id

    // CONSTRUCTOR DisasterVictim NOTE: String must be a valid date in order for no exception to be thrown
    public DisasterVictim(String firstName, String ENTRY_DATE) {
        try {
            LocalDate.parse(ENTRY_DATE, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid entry date format. Please use YYYY-MM-DD.");
            return;
        }
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = ++instance_count; // Example of setting unique ID, adjust as needed
        this.lastName = "";
        this.dateOfBirth = null;
        this.comments = "";
        this.medicalRecords = new MedicalRecord[0];
        this.familyConnections = new FamilyRelation[0];
        this.personalBelongings = new Supply[0];
        this.gender = "";
    }

    // GETTERS

    // returns String firstName
    public String getFirstName() {
        return firstName;
    }
    // returns String lastName
    public String getLastName() {
        return lastName;
    }
    // returns String dateOfBirth
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    // returns String comments
    public String getComments() {
        return comments;
    }
    // returns array of MedicalRecord via variable medicalRecords
    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords;
    }
    // returns String ENTRY_DATE
    public String getEntryDate() {
        return ENTRY_DATE;
    }
    // returns int ASSIGNED_SOCIAL_ID
    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }
    // returns array of Supply via variable personalBelongings
    public Supply[] getPersonalBelongings() {
        return personalBelongings;
    }
    // returns array of FamilyRelation via variable familyConnections
    public FamilyRelation[] getFamilyConnections() {
        return familyConnections;
    }
    // returns String gender
    public String getGender() {
        return gender;
    }

    // SETTERS

    // Takes in String param and sets it to firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // Takes in String param and sets it to lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // Takes in String param and sets it to dateOfBirth if the String is a valid date
    public void setDateOfBirth(String dateOfBirth) {
        try {
            LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use YYYY-MM-DD.");
        }
        this.dateOfBirth = dateOfBirth;
    }
    // Takes in String param and sets it to comments
    public void setComments(String comments) {
        this.comments = comments;
    }
    // Takes in MedicalRecord array param and sets it to medicalRecords
    public void setMedicalRecords(MedicalRecord[] medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
    // Takes in Supply array param and sets it to personalBelongings
    public void setPersonalBelongings(Supply[] supplies) {
        this.personalBelongings = supplies;
    }
    // Takes in FamilyRelation array param and sets it to relations
    public void setFamilyConnections(FamilyRelation[] relations) {
        this.familyConnections = relations;
    }
    // Takes in String param and sets it to gender
    public void setGender(String gender) {
        this.gender = gender;
    }

   // Takes in a valid Supply object and adds it to the personalBelongings list
   public void addPersonalBelonging(Supply supply) {
        // creates a new array of size 1 if an object has not been added
        if (this.personalBelongings == null) {
            this.personalBelongings = new Supply[1];
            this.personalBelongings[0] = supply;
        } else {
            this.personalBelongings = Arrays.copyOf(this.personalBelongings, this.personalBelongings.length + 1);
            this.personalBelongings[this.personalBelongings.length - 1] = supply;
        }
    }
    // Takes in a valid Supply object currently located within the personalBelongings array, if found 
    // removes it from the array by creating a new one to resize the array
    public void removePersonalBelonging(Supply supply) {
        // array must not be null and have at least one object
        if (this.personalBelongings != null && this.personalBelongings.length > 0) {
            int removeIndex = -1;
            for (int i = 0; i < this.personalBelongings.length; i++) {
                if (this.personalBelongings[i].equals(supply)) {
                    removeIndex = i;
                    break; 
                }
            }
             // If supply found
            if (removeIndex != -1) { 
                Supply[] newArray = new Supply[this.personalBelongings.length - 1];
                for (int i = 0, j = 0; i < this.personalBelongings.length; i++) {
                    if (i != removeIndex) {
                        newArray[j++] = this.personalBelongings[i];
                    }
                }
                this.personalBelongings = newArray;
            }
        }
    }
    // Takes in a valid Supply object currently located within the personalBelongings array, if found 
    // removes it from the array by creating a new one to resize the array
    public void addFamilyConnection(FamilyRelation familyConnection) {
        // if familyConnections has no FamilyRelation added to it
        if (this.familyConnections == null) {
            this.familyConnections = new FamilyRelation[1];
            this.familyConnections[0] = familyConnection;
        } else {
            this.familyConnections = Arrays.copyOf(this.familyConnections, this.familyConnections.length + 1);
            this.familyConnections[this.familyConnections.length - 1] = familyConnection;
        }
    }
    // Takes in a valid FamilyRelation object and adds it to the personalBelongings array
    // and removes it from the array by creating a temporary one to resize the array
    public void removeFamilyConnection(FamilyRelation familyConnection) {
        // array must not be null and have at least one object
        if (this.familyConnections != null && this.familyConnections.length > 0) {
            int removeIndex = -1;
            for (int i = 0; i < this.familyConnections.length; i++) {
                if (this.familyConnections[i].equals(familyConnection)) {
                    removeIndex = i;
                    break; 
                }
            }
            // If familyConnection found
            if (removeIndex != -1) { 
                FamilyRelation[] newArray = new FamilyRelation[this.familyConnections.length - 1];
                for (int i = 0, j = 0; i < this.familyConnections.length; i++) {
                    if (i != removeIndex) {
                        newArray[j++] = this.familyConnections[i];
                    }
                }
                this.familyConnections = newArray;
            }
        }
    }
    // Takes in a valid MedicalRecord object and adds it to the medicalRecords list
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        // creates a new array of size 1 if an object has not been added
        if (this.medicalRecords == null) {
            this.medicalRecords = new MedicalRecord[1];
            this.medicalRecords[0] = medicalRecord;
        } else {
            this.medicalRecords = Arrays.copyOf(this.medicalRecords, this.medicalRecords.length + 1);
            this.medicalRecords[this.medicalRecords.length - 1] = medicalRecord;
        }
    }
}

