import java.util.LinkedList;

public class Car {
    private String carLicensePlate;
    private String carMake;
    private String carModel;
    private String carResidencyTime;
    private int ownerID;
    private int jobID;
    private LinkedList<Job> Jobs = new LinkedList<Job>();

    public Car(String carLicensePlate, String carMake, String carModel, String carResidencyTime, int ownerID) {
        this.carLicensePlate = carLicensePlate;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carResidencyTime = carResidencyTime;
        this.ownerID = ownerID;
        this.jobID = 0; // Set job ID to 0 to indicate that the car is currently available for hire
    }

    public LinkedList<Job> getJobs() {
        return Jobs;
    }

    public Boolean addJob(Job job) {
        Jobs.add(job);
        return true;
    }

    public void removeJob(Job job) {
        Jobs.remove(job);
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

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
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
}
