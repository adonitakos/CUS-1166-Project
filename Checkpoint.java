import java.util.Date;

public class Checkpoint {

    private int checkpointID;
    private Car car;
    private Date checkInTime;
    private Date checkOutTime;
    //private Date time;        Not sure what this is used for

    public Checkpoint(int checkpointID, Car car) {
        this.checkpointID = checkpointID;
        this.car = car;
    }

    public int getCheckpointID() {
        return checkpointID;
    }

    public Car getCar() {
        return car;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date time) {
        checkInTime = time;
    }

    public void setCheckOutTime(Date time) {
        checkOutTime = time;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

}
