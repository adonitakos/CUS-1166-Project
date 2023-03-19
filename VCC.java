import java.util.*;
import java.io.*;

public class VCC {

	//  Not sure if these need to be placed in the VCC class as well
	private int checkpointID;
	//private Vehicle vehicle;
	private Date checkInTime;
	private Date checkOutTime;
	private Date time;
     


	private LinkedList<Car> Cars = new LinkedList<Car>();
	private Queue<Job> JobsQueue = new LinkedList<Job>();
	private LinkedList<Job> AllJobs = new LinkedList<Job>();
	private static VCC single_instance = null;

	private VCC() {
	}

	public static synchronized VCC getInstance() {
		if (single_instance == null)
			single_instance = new VCC();

		return single_instance;
	}

	public void importJobsFromFile(String path) {//not complete
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
		return AllJobs;
	}

	public Queue<Job> getCompleteJobs() {
		
	}

	public Queue<Job> getIncompleteJobs() {

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
		for (int i = 0; i < AllJobs.size(); i++) {
			if (AllJobs.get(i).getJobID() == jobID) {
				return AllJobs.get(i);
			}
		}
		return null;
	}

	public Boolean assignJobs(int jobId, int carId) {

	}

	public Boolean deleteCar(int carId) {

	}

	public Boolean addCar(Car car) {
		try {
			FileWriter myWriter = new FileWriter("carInfo.txt");
			myWriter.write("Files in Java might be tricky, but it is fun enough!");
			myWriter.close();
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
	}

	public Boolean deleteJob(int jobId) {

	}

	public Boolean addJob(Job job) {
		try {
			FileWriter myWriter = new FileWriter("jobInfo.txt");
			myWriter.write(job);
			myWriter.close();
		  } catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }
	}

	public Boolean transferJobsBetweenCars(int jobID, int originalCarID, int newCarID) {

	}

	public Boolean transferCompletedJobs() {

	}

	public Boolean createCheckPoint(int checkpointID, Date CheckInTime, Date CheckOutTime) // (Vehicle vehicle)
	 {
		Checkpoint checkpoint = new Checkpoint(checkpointID);//vehicle); edited once vehicle is properly assignable
		checkpoint.setCheckInTime(checkInTime);
		checkpoint.setCheckOutTime(checkOutTime);
		checkpoint.add(checkpoint);
		return true;




	}

	public Boolean transferCheckpoint() {
		//Boolean checkpointData = VCC.createCheckPoint(checkpointID,vehicle, checkinTime, checkoutTime);

	}

	
}
