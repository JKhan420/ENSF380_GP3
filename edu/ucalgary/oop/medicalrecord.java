package edu.ucalgary.oop;
// GROUP 22
public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;


    // Constructor

    ////NOT DONE
    public MedicalRecord(Location location,String treatmentDetails, String dateOfTreatment){
        // Check if any arguments are null and if so throw illegal argument exception
        if (location == null || treatmentDetails == null || dateOfTreatment == null) {
            throw new IllegalArgumentException("Location, treatment details, and date of treatment cannot be null.");
        }

        // Check the format of dateOfTreatment
        try {
            java.time.LocalDate.parse(dateOfTreatment, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (java.time.format.DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.");
        }

        this.location = location;
        this.treatmentDetails = treatmentDetails;
        this.dateOfTreatment = dateOfTreatment;
    }

    // Getters
    public Location getLocation() {
        return location;
    }
    public String getTreatmentDetails() {
        return treatmentDetails;
    }
    public String getDateOfTreatment() {
        return dateOfTreatment;
    }
    // Seters
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }
    public void setDateOfTreatment(String dateOfTreatment) {
        try {
            java.time.LocalDate.parse(dateOfTreatment, java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (java.time.format.DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.");
        }
        this.dateOfTreatment = dateOfTreatment;
    }


}

