/* Project: Vehicle Vortex
*  Class: Job.java
*  Author: Antonios Takos, Summer Snyder, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*  Date: April 16th, 2023
*  This file contains the classes that will be used for the Job.
*/

import java.io.Serializable;

public class Job implements Serializable {
    // Initialize variables
    private int jobID;
    private int jobDuration;// in hours
    private String jobDeadline;
    private Boolean completionStatus = false;
    private int jobRedundancy;
    private int completionTime;
    private String jobDescription;
    private int ownerID;
    private int currentCarNum;

    public Job(int jobID, int jobDuration, String jobDeadline, String jobDescription) {
        this.jobID = jobID;
        this.jobDuration = jobDuration;
        this.jobDeadline = jobDeadline;
        this.jobDescription = jobDescription;
    }

    public void setCurrentCarNum(int currentCarNum) {
        this.currentCarNum = currentCarNum;
    }

    public int getCurrentCarNum() {
        return currentCarNum;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int time) {
        completionTime = time;
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

} // <--- Job{} class ends here