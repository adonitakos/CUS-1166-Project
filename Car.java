import java.io.Serializable;

public class Car implements Serializable{
    private String carLicensePlate;
    private String carMake;
    private String carModel;
    private String carResidencyTime;
    private String carID;
    private int jobID;
    private Job Job;

    public Car(String carID, String carLicensePlate, String carMake, String carModel, String carResidencyTime) {
        this.carLicensePlate = carLicensePlate;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carResidencyTime = carResidencyTime;
        this.carID = carID; // Set job ID to 0 to indicate that the car is currently available for hire
    }

    public Job getJob() {
        return Job;
    }

    public void setJob(Job job) {
        this.Job = job;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
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
        return "Car ID: " + this.carID + ", Make: " + this.carMake + ", Model: " + this.carModel + ", Residency Time: " + this.carResidencyTime;
    }
}
