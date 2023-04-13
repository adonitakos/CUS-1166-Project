import java.util.*;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class VCC {

	private static int generalRedundancy = 5;
	private static LinkedList<Car> Cars = new LinkedList<Car>();
	private static Queue<Job> jobsQueue = new LinkedList<Job>();
	private static LinkedList<Job> allJobs = new LinkedList<Job>();
	private static LinkedList<User> users = new LinkedList<User>();
	private static VCC single_instance = null;
	private static int queueTime = 0;

	public static void init() throws ClassNotFoundException {
		DBConnection.init("vehicle_vortex");
	}

	private static Connection conn;

	private static Car buildCar(ResultSet rs) throws SQLException {
		rs.next();
		String carLicensePlate = rs.getString("plateNum");
		String carMake = rs.getString("make");
		String carModel = rs.getString("model");
		String carResidencyTime = rs.getString("time");
		int ownerID = rs.getInt("ownerID");// Ask and delete
		Car car = new Car(carLicensePlate, carMake, carModel, carResidencyTime, ownerID);
		return car;
	}

	private static Job buildJob(ResultSet rs) throws SQLException {
		rs.next();
		int jobID = rs.getInt("jobID");
		int jobDuration = rs.getInt("duration");// Ask and delete
		String jobDeadline = rs.getString("deadline");
		String jobDescription = rs.getString("description");
		int completionStatus = rs.getInt("status");
		int jobRedundancy = rs.getInt("redundancy");
		int completionTime = rs.getInt("completionTime");// Ask and delete
		Job job = new Job(jobID, jobDuration, jobDeadline, jobDescription);
		job.setCompletionTime(completionTime);
		job.setJobRedundancy(jobRedundancy);
		if (completionStatus == 0) {
			job.setStatus(false);
		} else if (completionStatus == 1) {
			job.setStatus(true);
		}
		return job;
	}

	private static User buildUser(ResultSet rs) throws SQLException {
		rs.next();
		int userID = rs.getInt("userID");// Ask and delete
		String userName = rs.getString("username");
		String userPassword = rs.getString("password");
		String type = rs.getString("userType");
		User user = new User(userID, userName, userPassword);
		user.setType(type);
		return user;
	}

	private static LinkedList<User> buildUserList(ResultSet rs) throws SQLException {
		LinkedList<User> users = new LinkedList<User>();
		while (rs.next()) {
			User user = buildUser(rs);
			users.add(user);
		}
		return users;
	}

	private static LinkedList<Job> buildJobList(ResultSet rs) throws SQLException {
		LinkedList<Job> jobs = new LinkedList<Job>();
		while (rs.next()) {
			Job job = buildJob(rs);
			jobs.add(job);
		}
		return jobs;
	}

	private static LinkedList<Car> buildCarList(ResultSet rs) throws SQLException {
		LinkedList<Car> cars = new LinkedList<Car>();
		while (rs.next()) {
			Car car = buildCar(rs);
			cars.add(car);
		}
		return cars;
	}

	private VCC() {
	}

	public static synchronized VCC getInstance() {
		if (single_instance == null)
			single_instance = new VCC();

		return single_instance;
	}

	public LinkedList<User> getUsers() {
		return users;
	}

	public Queue<Job> getQueue() {
		return jobsQueue;
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

	public Car getCarById(String plateNum) throws ClassNotFoundException, SQLException {
		conn = DBConnection.getMyConnection();
		Car car;
		String query = ("select * from cars where plateNum like ?");
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, plateNum);
		ResultSet rs = stmt.executeQuery();
		car = buildCar(rs);
		stmt.close();
		return car;
	}

	public Job getJobById(int jobID) throws ClassNotFoundException, SQLException {
		conn = DBConnection.getMyConnection();
		Job job;
		String query = ("select * from jobs where jobID = ?");
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, jobID);
		ResultSet rs = stmt.executeQuery();
		job = buildJob(rs);
		stmt.close();
		return job;
	}

	public User getUser(String username, String password) throws SQLException, ClassNotFoundException {
		conn = DBConnection.getMyConnection();
		User user;
		String query = ("select * from users where username = ? and password = ?");
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		user = buildUser(rs);
		stmt.close();
		return user;
	}

	public void addUser(Use8i uykgbr user) {

	}

	public Boolean assignCarToJob(int jobId, String plateNum) throws ClassNotFoundException, SQLException {
		Job job = getJobById(jobId);
		Car car = getCarById(plateNum);
		if (car.getJob() == null && job.getCars().size() < job.getRedundancy()) {
			job.addCar(car);
			car.setJob(job);
		}
		return true;
	}

	public Boolean deleteCar(String plateNum) throws SQLException {
		conn = DBConnection.getMyConnection();
		String query = ("delete from cars, carowners,  where numPlate like ?");
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, plateNum);
		stmt.executeQuery();
		stmt.close();
		return true;
	}

	public Boolean addCar(Car car, User user) {
		Cars.add(car);
		// Write the user-provided credentials and timestamp to a file called
		// userInfo.txt, making it so that this information is not overwritten when the
		// program terminates and it is stored in a new line with each submission
		long now = System.currentTimeMillis();
		Timestamp sqlTimestamp = new Timestamp(now);
		try {
			FileWriter writer = new FileWriter("carInfo.txt", true); // true parameter to append to file

			writer.write("Owner ID: " + car.getOwnerID() + " | Car Make: " + car.getCarMake() + " | Car Model: "
					+ car.getCarModel()
					+ " | License Plate: " + car.getCarLicensePlate() + " | Residency Time: "
					+ car.getCarResidencyTime()
					+ " | Timestamp: " + sqlTimestamp + "\n");
			writer.close();
			System.out.println("User info successfully saved to file!");

			// success message
			System.out.println("Thank you. Your car has been submitted.");
		}
		// Error message
		catch (IOException ex) {
			System.out.println("Error writing user info to file.");
		}
		return true;
	}

	public Boolean deleteJob(int jobId) throws ClassNotFoundException, SQLException {
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
			System.out.print("Job not found." + "\n");
			while (!temp.isEmpty()) {
				jobsQueue.add(temp.peek());
				temp.remove();
			}
		} else {
			jobsQueue.remove();
			while (!temp.isEmpty()) {
				jobsQueue.add(temp.peek());
				temp.remove();
			}
			int k = size - count - 1;
			while (k-- > 0) {
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
		long now = System.currentTimeMillis();
		Timestamp sqlTimestamp = new Timestamp(now);
		try {
			FileWriter writer = new FileWriter("jobInfo.txt", true); // true parameter to append to file

			writer.write("Job ID: " + job.getJobID() + " | Job Duration: " + job.getJobDuration() + " | Job Deadline: "
					+ job.getJobDeadline() + " | Job Description: " + job.getJobDeadline() + " | Timestamp: "
					+ sqlTimestamp + "\n");
			writer.close();
			System.out.println("Job info successfully saved to file!");

			// confirmation message if successful
			System.out.println("Thank you. Your job has been submitted.");
		}
		// or error message if unsuccessful
		catch (IOException ex) {
			System.out.println("Error writing job info to file.");
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
