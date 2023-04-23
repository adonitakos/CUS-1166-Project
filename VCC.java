
/*  Project: Vehicle Vortex
*   Class: VCC.java 
*   Author: Antonios Takos, Summer Snyder, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*   Date: April 16th, 2023
*   This file contains the classes that will be used for the VCC.
*/
import java.util.*;

import javax.swing.table.DefaultTableColumnModel;

import java.sql.*;
import java.sql.Date;

public class VCC {

	private static int generalRedundancy = 5;
	private static LinkedList<Car> Cars = new LinkedList<Car>();
	private static Queue<Job> jobsQueue = new LinkedList<Job>();
	private static LinkedList<Job> allJobs = new LinkedList<Job>();
	private static LinkedList<User> users = new LinkedList<User>();
	private static VCC single_instance = null;

	public static void init() throws ClassNotFoundException {
		DBConnection.init();
	} // <--- init() method ends here

	private static Connection conn;

	private static Car buildCar(ResultSet rs) throws SQLException {
		rs.next();
		int carID = rs.getInt("carID");
		String carLicensePlate = rs.getString("plateNum");
		int ownerID = rs.getInt("carOwnerID");
		String carMake = rs.getString("make");
		String carModel = rs.getString("model");
		String carResidencyTime = rs.getString("time");
		int inUse = rs.getInt("inUse");
		int currentJobID = rs.getInt("currentJobID");
		Car car = new Car(carID, carLicensePlate, ownerID, carMake, carModel, carResidencyTime);
		if (inUse == 0) {
			car.setStatus(false);
		} else {
			car.setStatus(true);
		}
		car.setJobID(currentJobID);
		return car;
	} // <--- buildcar() method ends here

	private static Job buildJob(ResultSet rs) throws SQLException {
		rs.next();
		int jobID = rs.getInt("ID");
		int jobDuration = rs.getInt("duration");
		String jobDeadline = rs.getString("deadline");
		int completionStatus = rs.getInt("status");
		int jobRedundancy = rs.getInt("redundancy");
		int completionTime = rs.getInt("completionTime");
		String jobDescription = rs.getString("description");
		int ownerID = rs.getInt("jobOwnerID");
		int carsUsing = rs.getInt("carsUsingNum");
		Job job = new Job(jobID, jobDuration, jobDeadline, jobDescription);
		job.setCompletionTime(completionTime);
		job.setJobRedundancy(jobRedundancy);
		if (completionStatus == 0) {
			job.setStatus(false);
		} else if (completionStatus == 1) {
			job.setStatus(true);
		}
		job.setOwnerID(ownerID);
		job.setCurrentCarNum(carsUsing);
		return job;
	} // <--- buildJob() method ends here

	private static User buildUser(ResultSet rs) throws SQLException {
		rs.next();
		int userID = rs.getInt("ID");// Ask and delete
		String userName = rs.getString("username");
		String userPassword = rs.getString("password");
		String type = rs.getString("Type");
		User user = new User(userID, userName, userPassword);
		user.setType(type);
		return user;
	} // <--- buildUser() method ends here

	private static LinkedList<User> buildUserList(ResultSet rs) throws SQLException {
		LinkedList<User> users = new LinkedList<User>();
		while (rs.next()) {
			User user = buildUser(rs);
			users.add(user);
		}
		return users;
	} // <--- buildUserList() method ends here

	private static LinkedList<Job> buildJobList(ResultSet rs) throws SQLException {
		LinkedList<Job> jobs = new LinkedList<Job>();
		while (rs.next()) {
			Job job = buildJob(rs);
			jobs.add(job);
		}
		return jobs;
	} // <--- buildJobList() method ends here

	private static LinkedList<Car> buildCarList(ResultSet rs) throws SQLException {
		LinkedList<Car> cars = new LinkedList<Car>();
		while (rs.next()) {
			Car car = buildCar(rs);
			cars.add(car);
		}
		return cars;
	} // <--- buildCarList() method ends here

	private VCC() {
	}

	public static synchronized VCC getInstance() {
		if (single_instance == null)
			single_instance = new VCC();

		return single_instance;
	} // <--- getInstance() method ends here

	public LinkedList<User> getUsers() throws ClassNotFoundException, SQLException {
		conn = DBConnection.getMyConnection();
		LinkedList<User> users = new LinkedList<User>();
		String query = ("select * from users");
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		users = buildUserList(rs);
		stmt.close();
		return users;
	} // <--- getUsers() method ends here

	public Queue<Job> getQueue() {
		return jobsQueue;
	} // <--- getQueue() method ends here

	public LinkedList<Car> getAllCars() throws ClassNotFoundException, SQLException {
		conn = DBConnection.getMyConnection();
		LinkedList<Car> cars = new LinkedList<Car>();
		String query = ("select * from cars");
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		cars = buildCarList(rs);
		stmt.close();
		return cars;
	} // <--- getAllCars() method ends here

	public LinkedList<Job> getAllJobs() throws ClassNotFoundException, SQLException {
		conn = DBConnection.getMyConnection();
		LinkedList<Job> jobs = new LinkedList<Job>();
		String query = ("select * from jobs");
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		jobs = buildJobList(rs);
		stmt.close();
		return jobs;
	} // <--- getAllJobs() method ends here

	public LinkedList<Job> getCompleteJobs() {

		LinkedList<Job> completed = new LinkedList<Job>();
		for (int i = 0; i < allJobs.size(); i++) {
			if (allJobs.get(i).getStatus()) {
				completed.add(allJobs.get(i));
			}
		} // <--- for() loop ends here
		return completed;
	} // <--- getCompleteJobs() method ends here

	public LinkedList<Job> getIncompleteJobs() {
		LinkedList<Job> notCompleted = new LinkedList<Job>();
		for (int i = 0; i < allJobs.size(); i++) {
			if (!allJobs.get(i).getStatus()) {
				notCompleted.add(allJobs.get(i));
			}
		}
		return notCompleted;
	} // <--- getIncompleteJobs() method ends here

	public Car getCarById(String carID) throws ClassNotFoundException, SQLException {
		conn = DBConnection.getMyConnection();
		Car car;
		String query = ("select * from cars where carID like ?");
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, carID);
		ResultSet rs = stmt.executeQuery();
		car = buildCar(rs);
		stmt.close();
		return car;
	} // <--- getCarById() method ends here

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
	} // <--- getJobByID() method ends here

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
	} // <--- getUser() method ends here

	public Boolean addUser(User user) throws SQLException {
		conn = DBConnection.getMyConnection();
		String query = ("insert into users values (?,?,?,?)");
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, user.getUserID());
		stmt.setString(2, user.getUserName());
		stmt.setString(3, user.getUserPassword());
		stmt.setString(4, "User");
		stmt.executeUpdate();
		stmt.close();
		return true;
	} // <--- addUser() method ends here

	public Boolean addJob(Job job) throws SQLException {
		job.setRedundancy(generalRedundancy);
		conn = DBConnection.getMyConnection();
		String query = ("insert into jobs values (?,?,?,?,?,?,?,?,?,?)");
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, job.getJobID());
		stmt.setInt(2, job.getJobDuration());
		stmt.setString(3, job.getJobDeadline());
		stmt.setInt(4, 0);
		stmt.setInt(5, job.getRedundancy());
		String query2 = ("select sum(duration) as total from jobs");
		PreparedStatement stmt2 = conn.prepareStatement(query2);
		ResultSet rs = stmt2.executeQuery();
		rs.next();
		int total = rs.getInt(1) + job.getJobDuration();
		stmt.setInt(6, total);
		job.setCompletionTime(total);
		stmt.setString(7, job.getJobDescription());
		stmt.setInt(8, job.getOwnerID());
		System.out.println(job.getOwnerID());
		stmt.setInt(9, 0);
		stmt.setTimestamp(10, new java.sql.Timestamp(new java.util.Date().getTime()));
		stmt.executeUpdate();
		stmt.close();
		return true;
	} // <--- addJob() method ends here

	public Boolean addCar(Car car, User user) throws SQLException {
		conn = DBConnection.getMyConnection();
		String query = ("insert into cars values (?,?,?,?,?,?,?,?,?)");
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, car.getCarID());
		stmt.setString(2, car.getCarLicensePlate());
		stmt.setInt(3, car.getOwnerID());
		stmt.setString(4, car.getCarMake());
		stmt.setString(5, car.getCarModel());
		stmt.setString(6, car.getCarResidencyTime());
		stmt.setInt(7, 0);
		stmt.setNull(8, Types.INTEGER);
		stmt.setTimestamp(9, new java.sql.Timestamp(new java.util.Date().getTime()));
		stmt.executeUpdate();
		stmt.close();
		return true;
	} // <--- addCar() method ends here

	public Boolean addLogin(User user) throws SQLException {
		conn = DBConnection.getMyConnection();
		String query = ("insert into logins values (?,?)");
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, user.getUserID());
		stmt.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
		stmt.executeUpdate();
		stmt.close();
		return true;
	} // <--- addLogin() method ends here

	public Boolean assignCarToJob(int jobId, String plateNum) throws ClassNotFoundException, SQLException {
		Job job = getJobById(jobId);
		Car car = getCarById(plateNum);
		return true;
	} // <--- assignCarToJob() method ends here

	public Boolean deleteCar(String plateNum) throws SQLException {
		conn = DBConnection.getMyConnection();
		String query = ("delete from cars where numPlate like ?");
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, plateNum);
		stmt.executeQuery();
		stmt.close();
		return true;
	} // <--- deleteCar() method ends here

	public Boolean deleteJob(int jobId) throws ClassNotFoundException, SQLException {
		Queue<Job> temp = new LinkedList<>();
		Job job = getJobById(jobId);
		int size = jobsQueue.size();
		int count = 0;
		while (!jobsQueue.isEmpty() && jobsQueue.peek() != job) {
			temp.add(jobsQueue.peek());
			jobsQueue.remove();
			count++;
		} // <--- while() loop ends here
		if (jobsQueue.isEmpty()) {
			System.out.print("Job not found." + "\n");
			while (!temp.isEmpty()) {
				jobsQueue.add(temp.peek());
				temp.remove();
			} // <--- while() loop ends here
		} else {
			jobsQueue.remove();
			while (!temp.isEmpty()) {
				jobsQueue.add(temp.peek());
				temp.remove();
			} // <--- while() loop ends here
			int k = size - count - 1;
			while (k-- > 0) {
				Job tempJob = jobsQueue.peek();
				jobsQueue.remove();
				jobsQueue.add(tempJob);
			} // <--- while() looop ends here
		} // <--- else{} statement ends here
		allJobs.remove(job);
		return true;
	} // <--- deleteJob() method ends here

	public Boolean transferJobsBetweenCars(Job job, Car original, Car newCar) {
		// job.getCars().remove(original);
		// job.getCars().add(newCar);
		// original.setJob(null);
		// newCar.setJob(job);
		// // need to add checkpoint usage
		return true;
	} // <--- transferJobsBetweenCars() method ends here

	public Boolean completeJob() {
		Job compJob = jobsQueue.remove();
		compJob.setStatus(true);
		return true;
	} // <--- completeJobs() method ends here

	public Boolean createCheckPoint(Car Car, int checkpointID, Date checkInTime, Date checkOutTime) // (Vehicle vehicle)
	{
		Checkpoint checkpoint = new Checkpoint(checkpointID, Car);// vehicle); edited once vehicle is properly
																	// assignable
		checkpoint.setCheckInTime(checkInTime);
		checkpoint.setCheckOutTime(checkOutTime);
		// checkpoint.add(checkpoint); Not sure of purpose
		return true;
	} // <--- createCheckPoint() method ends here

	public Boolean transferCheckpoint() {
		// Boolean checkpointData = VCC.createCheckPoint(checkpointID,vehicle,
		// checkinTime, checkoutTime);
		return true;
	} // <--- transferCheckpoint() method ends here

} // <--- VCC{} class ends here