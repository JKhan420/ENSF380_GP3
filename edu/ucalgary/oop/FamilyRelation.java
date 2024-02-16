package edu.ucalgary.oop;
// GROUP 22
public class FamilyRelation {
    // FIELDS
    private DisasterVictim personOne;
    private String relationshipTo;
    private DisasterVictim personTwo;

    // CONSTRUCTOR for FamilyRelation

    public FamilyRelation(DisasterVictim personOne, String relationshipTo, DisasterVictim personTwo) {
        this.personOne = personOne;
        this.relationshipTo = relationshipTo;
        this.personTwo = personTwo;
    }

    // GETTERS
    
    // returns DisasterVictim personOne
    public DisasterVictim getPersonOne() {
        return personOne;
    }
    // returns String relationshipTo
    public String getRelationshipTo() {
        return relationshipTo;
    }
    // returns DisasterVictim personTwo
    public DisasterVictim getPersonTwo() {
        return personTwo;
    }

    // SETTERS

    // Takes in a DisasterVictim and sets it to personOne
    public void setPersonOne(DisasterVictim personOne) {
        this.personOne = personOne;
    }
    // Takes in a String and sets it to relationshipTo
    public void setRelationshipTo(String relationshipTo) {
        this.relationshipTo = relationshipTo;
    }
    // Takes in a DisasterVictim and sets it to personTwo
    public void setPersonTwo(DisasterVictim personTwo) {
        this.personTwo = personTwo;
    }
   
}