import java.util.*;
import java.io.*;

public class VCC {

	private static int generalRedundancy = 5;
	private static LinkedList<Car> Cars = new LinkedList<Car>();
	private static Queue<Job> jobsQueue = new LinkedList<Job>();
	private static LinkedList<Job> allJobs = new LinkedList<Job>();
	private static VCC single_instance = null;
	private static int queueTime = 0;

	private VCC() {
	}

	public static synchronized VCC getInstance() {
		if (single_instance == null)
			single_instance = new VCC();

		return single_instance;
	}

	public Boolean importJobFromFile(String path) {// not complete
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			while (objectIn.readObject() != null) {
				Object obj = objectIn.readObject();
				System.out.println("The Object has been read from the file");
				objectIn.close();
				Job job = (Job) obj;
				addJob(job);
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public Boolean importCarsFromFile(String path) {// needs to be completed
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			while (objectIn.readObject() != null) {
				Object obj = objectIn.readObject();
				System.out.println("The Object has been read from the file");
				objectIn.close();
				Car car = (Car) obj;
				addCar(car);
			}
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
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

	public Boolean assignCarToJob(int jobId, int carId) {
		Job job = getJobById(jobId);
		Car car = getCarById(carId);
		if (car.getJob() == null && job.getCars().size() < job.getRedundancy()) {
			job.addCar(car);
			car.setJob(job);
		}
		return true;
	}

	public Boolean deleteCar(int carId) {
		Cars.remove(getCarById(carId));
		return true;
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

	public Boolean deleteJob(int jobId)
	{
		Queue<Job> temp = new LinkedList<>();
		Job job = getJobById(jobId);
		int size = jobsQueue.size();
		int count = 0;
		while (!jobsQueue.isEmpty() && jobsQueue.peek() != job) {
			temp.add(jobsQueue.peek());
			jobsQueue.remove();
			count++;
		}
		if (jobsQueue.isEmpty()) {
			System.out.print("element not found!!" +"\n");
			while (!temp.isEmpty()) {
				jobsQueue.add(temp.peek());
				temp.remove();
			}
		}
		else {
			jobsQueue.remove();
			while (!temp.isEmpty()) {
				jobsQueue.add(temp.peek());
				temp.remove();
			}
			int k = size - count - 1;
			while (k-- >0) {
				Job tempJob = jobsQueue.peek();
				jobsQueue.remove();
				jobsQueue.add(tempJob);
			}
		}
		allJobs.remove(job);
		return true;
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
