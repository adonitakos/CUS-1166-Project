import java.util.Date;
import java.util.LinkedList;

public class Job {
    private int jobID;
    private int jobDuration;//in hours
    private String jobDeadline;
    private String jobDescription;
    private Boolean completionStatus = false;
    private int jobRedundancy;
    private int completionTime;
    private Date timestamp;
    private LinkedList<Car> Cars = new LinkedList<Car>();

    public Job(int jobID, int jobDuration, String jobDeadline, String jobDescription) {
        this.jobID = jobID;
        this.jobDuration = jobDuration;
        this.jobDeadline = jobDeadline;
        this.jobDescription = jobDescription;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date date) {
        timestamp = date;
    }

    public LinkedList<Car> getCars() {
        return Cars;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int time) {
        completionTime = time;
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

    public int getJobDuration() {
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

    public void setJobDuration(int jobDuration) {
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
