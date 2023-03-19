import java.util.*;
import java.io.*;

public class VCC {

	private int generalRedundancy = 5;
	private LinkedList<Car> Cars = new LinkedList<Car>();
	private Queue<Job> jobsQueue = new LinkedList<Job>();
	private LinkedList<Job> allJobs = new LinkedList<Job>();
	private static VCC single_instance = null;

	private VCC() {
	}

	public static synchronized VCC getInstance() {
		if (single_instance == null)
			single_instance = new VCC();

		return single_instance;
	}

	public void importJobsFromFile(String path) {// not complete
		try {
			File myObj = new File(path);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found.");
			e.printStackTrace();
		}
	}

	public LinkedList<Car> getAllCars() {
		return Cars;
	}

	public LinkedList<Job> getAllJobs() {
		return allJobs;
	}

	public LinkedList<Job> getCompleteJobs() {
		LinkedList<Job> completed = new LinkedList<Job>();
		for (int i = 0; i < allJobs.size(); i++) {
			if (allJobs.get(i).getStatus()) {
				completed.add(allJobs.get(i));
			}
		}
		return completed;
	}

	public LinkedList<Job> getIncompleteJobs() {
		LinkedList<Job> notCompleted = new LinkedList<Job>();
		for (int i = 0; i < allJobs.size(); i++) {
			if (!allJobs.get(i).getStatus()) {
				notCompleted.add(allJobs.get(i));
			}
		}
		return notCompleted;
	}

	public Car getCarById(int ownerId) {
		for (int i = 0; i < Cars.size(); i++) {
			if (Cars.get(i).getOwnerID() == ownerId) {
				return Cars.get(i);
			}
		}
		return null;
	}

	public Job getJobById(int jobID) {
		for (int i = 0; i < allJobs.size(); i++) {
			if (allJobs.get(i).getJobID() == jobID) {
				return allJobs.get(i);
			}
		}
		return null;
	}

	public Boolean assignJob(int jobId, int carId) {

	}

	public void deleteCar(int carId) {

	}

	public void addCar(Car car) {
		Cars.add(car);
	}

	public Boolean deleteJob(int jobId) {// needs to be completed

	}

	public Boolean addJob(Job job) {
		job.setRedundancy(generalRedundancy);
		allJobs.add(job);
		jobsQueue.add(job);
		return true;
	}

	public Boolean importJobs() {// needs to be completed
		try {
			FileWriter myWriter = new FileWriter("jobInfo.txt");
			myWriter.write(job);
			myWriter.close();
			return true;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public Boolean importCars() {// needs to be completed
		try {
			FileWriter myWriter = new FileWriter("carInfo.txt");
			myWriter.write("Files in Java might be tricky, but it is fun enough!");
			myWriter.close();
			return true;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public Boolean transferJobsBetweenCars(int jobID, int originalCarID, int newCarID) {

	}

	public Boolean completeJob() {
		Job compJob = jobsQueue.remove();
		compJob.setStatus(true);
		allJobs.add(compJob);
		return true;
	}

	public Boolean createCheckPoint(Car Car,int checkpointID, Date checkInTime, Date checkOutTime) // (Vehicle vehicle)
	{
		Checkpoint checkpoint = new Checkpoint(checkpointID, Car);// vehicle); edited once vehicle is properly assignable
		checkpoint.setCheckInTime(checkInTime);
		checkpoint.setCheckOutTime(checkOutTime);
		checkpoint.add(checkpoint);
		return true;
	}

	public Boolean transferCheckpoint() {
		// Boolean checkpointData = VCC.createCheckPoint(checkpointID,vehicle,
		// checkinTime, checkoutTime);

	}

}
