import java.util.*;
import java.io.*;

public class VCC {

	private int generalRedundancy = 5;
	private LinkedList<Car> Cars = new LinkedList<Car>();
	private Queue<Job> jobsQueue = new LinkedList<Job>();
	private LinkedList<Job> allJobs = new LinkedList<Job>();
	private static VCC single_instance = null;
	private int queueTime = 0;

	private VCC() {
	}

	public static synchronized VCC getInstance() {
		if (single_instance == null)
			single_instance = new VCC();

		return single_instance;
	}

	// public void importJobsFromFile(String path) {// not complete
	// 	try {
	// 		FileWriter myWriter = new FileWriter(path);
	// 		myWriter.write(job);
	// 		myWriter.close();
	// 		return true;
	// 	} catch (IOException e) {
	// 		System.out.println("An error occurred.");
	// 		e.printStackTrace();
	// 	}
	// } // <--- importJobsFromFile() method ends here

	public boolean importJobsFromFile(String path, Job job) {
		try {
			FileWriter myWriter = new FileWriter(path);
			myWriter.write(job.toString());
			myWriter.close();
			return true;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return false;
		}
	} // <--- importJobsFromFile() method ends here
	

	public Boolean importCarsFromFile(String path) {// needs to be completed
		try {
			FileWriter myWriter = new FileWriter(path);
			myWriter.write("Files in Java might be tricky, but it is fun enough!");
			myWriter.close();
			return true;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return null;
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

	public Boolean assignCarToJob(int jobId, int carId) {
		if() {

		}
	}

	public Boolean deleteCar(int carId) {
		for (int i = 0; i < Cars.size(); i++) {
			if (Cars.get(i).getOwnerID() == carId) {
				Cars.remove(i);
				return true;
			}
		}
		return null;
	}

	public Boolean addCar(Car car) {
		Cars.add(car);
		try {
			FileOutputStream fileOut = new FileOutputStream("carInfo.txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(car);
			objectOut.close();
			System.out.println("The Object  was succesfully written to a file");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	public Boolean deleteJob(int jobId) {// needs to be completed

	}

	public Boolean addJob(Job job) {
		job.setRedundancy(generalRedundancy);
		allJobs.add(job);
		jobsQueue.add(job);
		queueTime += job.getJobDuration();
		job.setCompletionTime(queueTime);
		try {
			FileOutputStream fileOut = new FileOutputStream("jobInfo.txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(job);
			objectOut.close();
			System.out.println("The Object  was succesfully written to the file");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}

	public Boolean transferJobsBetweenCars(Job job, Car original, Car newCar) {
		job.getCars().remove(original);
		job.getCars().add(newCar);
		original.setJob(null);
		newCar.setJob(job);
		// need to add checkpoint usage
		return true;
	}

	public Boolean completeJob() {
		Job compJob = jobsQueue.remove();
		compJob.setStatus(true);
		allJobs.add(compJob);
		return true;
	}

	public Boolean createCheckPoint(Car Car, int checkpointID, Date checkInTime, Date checkOutTime) // (Vehicle vehicle)
	{
		Checkpoint checkpoint = new Checkpoint(checkpointID, Car);// vehicle); edited once vehicle is properly
																	// assignable
		checkpoint.setCheckInTime(checkInTime);
		checkpoint.setCheckOutTime(checkOutTime);
		// checkpoint.add(checkpoint); Not sure of purpose
		return true;
	}

	public Boolean transferCheckpoint() {
		// Boolean checkpointData = VCC.createCheckPoint(checkpointID,vehicle,
		// checkinTime, checkoutTime);
		return true;

	}

}
