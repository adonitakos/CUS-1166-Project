import java.util.LinkedList;

public abstract class Job {
    private int jobID;
    private String jobDuration;
    private String jobDeadline;
    private String jobDescription;
    private Boolean completionStatus;
    private int jobRedundancy;
    private LinkedList<Car> Cars = new LinkedList<Car>();

    public Job(int jobID, String jobDuration, String jobDeadline, String jobDescription, int jobRedundancy) {
        this.jobID = jobID;
        this.jobDuration = jobDuration;
        this.jobDeadline = jobDeadline;
        this.jobDescription = jobDescription;
        this.jobRedundancy = jobRedundancy;
    }

    public LinkedList<Car> getCars() {
        return Cars;
    }

    public Boolean addCar(Car car) {
        if (Cars.size() < jobRedundancy) {
            Cars.add(car);
            return true;
        } else {
            return false;
        }
    }

    public void removeCar(Car car) {
        Cars.remove(car);
    }

    public int getRedundancy() {
        return jobRedundancy;
    }

    public void setRedundancy(int redundancy) {
        this.jobRedundancy = redundancy;
    }

    public Boolean getStatus() {
        return completionStatus;
    }

    public void setStatus(Boolean status) {
        this.completionStatus = status;
    }

    public int getJobID() {
        return jobID;
    }

    public String getJobDuration() {
        return jobDuration;
    }

    public String getJobDeadline() {
        return jobDeadline;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public int getJobRedundancy() {
        return jobRedundancy;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public void setJobDuration(String jobDuration) {
        this.jobDuration = jobDuration;
    }

    public void setJobDeadline(String jobDeadline) {
        this.jobDeadline = jobDeadline;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public void setJobRedundancy(int jobRedundancy) {
        this.jobRedundancy = jobRedundancy;
    }

    public void performJob() {
        System.out.println("This job is being performed.");
    }
}
