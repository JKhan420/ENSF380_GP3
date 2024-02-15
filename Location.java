public class Location {
    // Fields
    private String name;
    private String address;
    private DisasterVictim[] occupants;
    private Supply[] supplies;

    // Constructor
    public Location(String name, String address) {
        this.name = name;
        this.address = address;
        this.occupants = new DisasterVictim[0]; // Initialize occupants array
        this.supplies = new Supply[0]; // Initialize supplies array
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for occupants
    public DisasterVictim[] getOccupants() {
        return occupants;
    }

    // Setter for occupants
    public void setOccupants(DisasterVictim[] occupants) {
        this.occupants = occupants;
    }

    // Getter for supplies
    public Supply[] getSupplies() {
        return supplies;
    }

    // Setter for supplies
    public void setSupplies(Supply[] supplies) {
        this.supplies = supplies;
    }

    // Method to add an occupant
    public void addOccupant(DisasterVictim occupant) {
        DisasterVictim[] newOccupants = new DisasterVictim[occupants.length + 1];
        System.arraycopy(occupants, 0, newOccupants, 0, occupants.length);
        newOccupants[occupants.length] = occupant;
        occupants = newOccupants;
    }

    // Method to remove an occupant
    public void removeOccupant(DisasterVictim occupant) {
        int index = -1;
        for (int i = 0; i < occupants.length; i++) {
            if (occupants[i].equals(occupant)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            DisasterVictim[] newOccupants = new DisasterVictim[occupants.length - 1];
            System.arraycopy(occupants, 0, newOccupants, 0, index);
            System.arraycopy(occupants, index + 1, newOccupants, index, occupants.length - index - 1);
            occupants = newOccupants;
        }
    }

    // Method to add a supply
    public void addSupply(Supply supply) {
        Supply[] newSupplies = new Supply[supplies.length + 1];
        System.arraycopy(supplies, 0, newSupplies, 0, supplies.length);
        newSupplies[supplies.length] = supply;
        supplies = newSupplies;
    }

    // Method to remove a supply
    public void removeSupply(Supply supply) {
        int index = -1;
        for (int i = 0; i < supplies.length; i++) {
            if (supplies[i].equals(supply)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Supply[] newSupplies = new Supply[supplies.length - 1];
            System.arraycopy(supplies, 0, newSupplies, 0, index);
            System.arraycopy(supplies, index + 1, newSupplies, index, supplies.length - index - 1);
            supplies = newSupplies;
        }
    }
}
