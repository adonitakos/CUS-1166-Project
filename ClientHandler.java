/* Project: Vehicle Vortex
*  Class: ClientHandler.java
*  Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
*  Date: April 16th, 2023 
*/

import java.io.*;
import java.net.*;

import javax.swing.SwingUtilities;

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
                    Object object = OIS.readObject();
                    if (object instanceof Job) {// Job type object being recieved
                        System.out.println("Job request recieved...");
                        Job job = (Job) object;
                        System.out.println("Object converted to job...");
                        System.out.println("Popup created...1");
                        CreateAdminForm jobForm = new CreateAdminForm(job, socket, inputStream, outputStream);
                        jobForm.setSize(400, 300);
                        jobForm.setVisible(true);
                        System.out.println("Popup created...");

                    } else if (object instanceof Car) {// Car type object being recieved
                        System.out.println("Car request recieved...");
                        Car car = (Car) object;
                        System.out.println("Object converted to car...");
                        System.out.println("Popup created...1");
                        CreateAdminForm carForm = new CreateAdminForm(car, socket, inputStream, outputStream);
                        carForm.setSize(400, 300);
                        carForm.setVisible(true);
                        System.out.println("Popup created...");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } // <--- while(true) loop ends here
        } catch (IOException e) {
            e.printStackTrace();
        }

    } // <--- run() method ends here

} // <--- ClientHandler{} class ends here