import java.util.*;

public class VCC {

	private LinkedList<Car> Cars = new LinkedList<Car>();
	private Queue<Job> Jobs = new LinkedList<Job>();
	private static VCC single_instance = null;

	private VCC() {
	}

	public static synchronized VCC getInstance() {
		if (single_instance == null)
			single_instance = new VCC();

		return single_instance;
	}

	public LinkedList<Car> getAllCars() {
		return Cars;
	}

	public Queue<Job> getAllJobs() {
		return Jobs;
	}

	public Queue<Job> getCompleteJobs() {
		
	}

	public List<Job> getIncompleteJobs() {

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

	}

	public Boolean assignJobs(int jobId, int carId) {

	}

	public Boolean deleteCar(int carId) {

	}

	public Boolean addCar(Car car) {

	}

	public Boolean deleteJob(int jobId) {

	}

	public Boolean addJob(Job job) {

	}

	public Boolean transferJobsBetweenCars(int jobID, int originalCarID, int newCarID) {

	}

	public Boolean transferCompletedJobs(int jobId) {

	}

	public Boolean createCheckPoint() {

	}

	public Boolean transferCheckpoint() {

	}

}
