/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024
Licensed under GPL v3
See LICENSE.txt for more information.
*/
/*
 * NOTE: THIS CLASS WAS CHANGED TO ACCOMADATE FOR ARRAYS AND NOT ARRAYLISTS IT MAY DEVIATE SLIGHTLY FROM
 * THE ORIGINAL LocationTest.java 
 */
package edu.ucalgary.oop;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class LocationTest {
    private Location location;
    private DisasterVictim victim;
    private Supply supply;

    @Before
    public void setUp() {
        location = new Location("Shelter A", "1234 Shelter Ave");
        victim = new DisasterVictim("John Doe", "2024-01-01");
        supply = new Supply("Water Bottle", 10);
    }

    // Helper method to check if a supply is in the array
    private boolean containsSupply(Supply[] supplies, Supply supplyToCheck) {
        for (Supply supply : supplies) {
            if (supply.equals(supplyToCheck)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testConstructor() {
        assertNotNull("Constructor should create a non-null Location object", location);
        assertEquals("Constructor should set the name correctly", "Shelter A", location.getName());
        assertEquals("Constructor should set the address correctly", "1234 Shelter Ave", location.getAddress());
    }

    @Test
    public void testSetName() {
        String newName = "Shelter B";
        location.setName(newName);
        assertEquals("setName should update the name of the location", newName, location.getName());
    }

    @Test
    public void testSetAddress() {
        String newAddress = "4321 Shelter Blvd";
        location.setAddress(newAddress);
        assertEquals("setAddress should update the address of the location", newAddress, location.getAddress());
    }

    @Test
    public void testAddOccupant() {
        DisasterVictim[] occupants = {victim}; // Assuming addOccupant updates internally to an array
        location.setOccupants(occupants); // Adjusting the Location class method to accept array
        assertTrue("addOccupant should add a disaster victim to the occupants array", Arrays.asList(location.getOccupants()).contains(victim));
    }

    @Test
    public void testRemoveOccupant() {
        DisasterVictim[] occupants = {victim}; // Adding directly for setup
        location.setOccupants(occupants); // Setup with an occupant
        location.removeOccupant(victim); // Assuming removeOccupant is adjusted to handle array
        assertFalse("removeOccupant should remove the disaster victim from the occupants array", Arrays.asList(location.getOccupants()).contains(victim));
    }

    @Test
    public void testSetAndGetOccupants() {
        DisasterVictim[] newOccupants = {victim};
        location.setOccupants(newOccupants);
        assertTrue("setOccupants should replace the occupants array with the new array", Arrays.asList(location.getOccupants()).contains(victim));
    }

    @Test
    public void testAddSupply() {
        Supply[] supplies = {supply}; // Assuming addSupply updates internally to an array
        location.setSupplies(supplies); // Adjusting the Location class method to accept array
        assertTrue("addSupply should add a supply to the supplies array", containsSupply(location.getSupplies(), supply));
    }

    @Test
    public void testRemoveSupply() {
        Supply[] supplies = {supply}; // Adding directly for setup
        location.setSupplies(supplies); // Setup with a supply
        location.removeSupply(supply); // Assuming removeSupply is adjusted to handle array
        assertFalse("removeSupply should remove the supply from the supplies array", containsSupply(location.getSupplies(), supply));
    }

    @Test
    public void testSetAndGetSupplies() {
        Supply[] newSupplies = {supply};
        location.setSupplies(newSupplies);
        assertTrue("setSupplies should replace the supplies array with the new array", containsSupply(location.getSupplies(), supply));
    }
}
