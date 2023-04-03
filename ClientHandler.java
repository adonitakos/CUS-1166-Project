import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class ClientHandler extends Thread {
    final DataInputStream inputStream;
    final DataOutputStream outputStream;
    final Socket socket;

    // Constructor
    public ClientHandler(Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    } // <--- ClientHandler() constructor ends here

    public void run() {
        try (ObjectInputStream OIS = new ObjectInputStream(inputStream)) {
            while (true) {
                try {
                    // Receive the answer from client
                    if (OIS.readObject() instanceof Job) {// Job type object being recieved
                        Job job = (Job) OIS.readObject();
                        CreateAdminForm jobForm = new CreateAdminForm(job);
                    } else if (OIS.readObject() instanceof Car) {// Car type object being recieved
                        Car car = (Car) OIS.readObject();
                        CreateAdminForm carForm = new CreateAdminForm(car);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } // <--- while(true) loop ends here
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    } // <--- run() method ends here

} // <--- ClientHandler{} class ends here
