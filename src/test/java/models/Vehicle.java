package models;

/**
 * Represents a Vehicle with registration number, make, model, and year.
 */
public class Vehicle {
    
    /**
     * The registration number of the vehicle.
     */
    private String regNumber;

    /**
     * The make of the vehicle (e.g., Toyota, BMW).
     */
    private String make;

    /**
     * The model of the vehicle (e.g., Corolla, 3 Series).
     */
    private String model;

    /**
     * The year of manufacture of the vehicle.
     */
    private String year;

    /**
     * Constructs a new Vehicle with the specified registration number, make, model, and year.
     *
     * @param regNumber the registration number of the vehicle
     * @param make the make of the vehicle
     * @param model the model of the vehicle
     * @param year the year of manufacture of the vehicle
     */
    public Vehicle(String regNumber, String make, String model, String year) {
        this.regNumber = regNumber;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    /**
     * Gets the registration number of the vehicle.
     *
     * @return the registration number
     */
    public String getRegNumber() {
        return regNumber;
    }

    /**
     * Gets the make of the vehicle.
     *
     * @return the make of the vehicle
     */
    public String getMake() {
        return make;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return the model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Gets the year of manufacture of the vehicle.
     *
     * @return the year of manufacture
     */
    public String getYear() {
        return year;
    }
}
