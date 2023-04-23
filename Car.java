
/* Project: Vehicle Vortex
*  Class: Car.java
*  Author: Antonios Takos, Summer Snyder, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*  Date: April 16th, 2023 
*  This file contains the classes that will be used for the Car.
*/
import java.io.Serializable;

public class Car implements Serializable {

    // Initializing Variables
    private int carID;
    private String carLicensePlate;
    private int ownerID;
    private String carMake;
    private String carModel;
    private String carResidencyTime;
    private Boolean inUse = false;
    private int jobID;

    public Car(int carID, String carLicensePlate, int ownerID, String carMake, String carModel,
            String carResidencyTime) {
        this.carLicensePlate = carLicensePlate;
        this.carMake = carMake;
        this.carModel = carModel;
        this.ownerID = ownerID;
        this.carResidencyTime = carResidencyTime;
        this.carID = carID;
        this.jobID = 0; // Set job ID to 0 to indicate that the car is currently available for hire
    }

    public void setStatus(Boolean status) {
        this.inUse = status;
    }

    public Boolean getStatus() {
        return inUse;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public String getCarLicensePlate() {
        return carLicensePlate;
    }

    public void setCarLicensePlate(String carLicensePlate) {
        this.carLicensePlate = carLicensePlate;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarResidencyTime() {
        return carResidencyTime;
    }

    public void setCarResidencyTime(String carResidencyTime) {
        this.carResidencyTime = carResidencyTime;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public void listCarForHire() {
        this.jobID = 0; // Set job ID to 0 to indicate that the car is currently available for hire
    }

    public void hireCarForJob(int jobID) {
        this.jobID = jobID; // Set job ID to the specified job ID to indicate that the car is being used for
                            // a job
    }

    public void updateCarInfo(String carMake, String carModel, String carResidencyTime) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.carResidencyTime = carResidencyTime;
    }

    public String getCarInfo() {
        return "Make: " + this.carMake + ", Model: " + this.carModel + ", Residency Time: " + this.carResidencyTime;
    }

} // <--- Car{} ends here