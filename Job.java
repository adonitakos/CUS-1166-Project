import java.util.LinkedList;

public class Job {
    private static int jobID;
    private static int jobDuration;//in hours
    private static String jobDeadline;
    private static String jobDescription;
    private Boolean completionStatus = false;
    private static Job single_instance = null;
    private int jobRedundancy;
    private static int completionTime;
    private LinkedList<Car> Cars = new LinkedList<Car>();

    private Job() {
    }

    public static synchronized Job getInstance() {
		if (single_instance == null)
			single_instance = new Job();

		return single_instance;
	}

    public Job(int jobID, int jobDuration, String jobDeadline, String jobDescription) {
        this.jobID = jobID;
        this.jobDuration = jobDuration;
        this.jobDeadline = jobDeadline;
        this.jobDescription = jobDescription;
    }

    public LinkedList<Car> getCars() {
        return Cars;
    }

    public static int getCompletionTime() {
        return completionTime;
    }

    public static void setCompletionTime(int time) {
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

    public static int getJobID() {
        return jobID;
    }

    public static int getJobDuration() {
        return jobDuration;
    }

    public static String getJobDeadline() {
        return jobDeadline;
    }

    public static String getJobDescription() {
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
