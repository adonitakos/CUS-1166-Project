import java.io.*;
import java.net.*;

import javax.swing.SwingUtilities;

public class ClientHandler extends Thread implements ActionListener{
    final DataInputStream inputStream;
    final DataOutputStream outputStream;
    final Socket socket;

    // Constructor
    public ClientHandler(Socket socket, DataInputStream inputStream, DataOutputStream outputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    } // <--- ClientHandler() constructor ends here

    private static void jobFormCreation(Job job) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAdminForm jobForm = new CreateAdminForm(job, this.socket, inputStream, outputStream);
                System.out.println("Popup created...");
            }
        });
    }

    private static void carFormCreation(Car car) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAdminForm carForm = new CreateAdminForm(car, socket, inputStream, outputStream);
                System.out.println("Popup created...");
            }
        });
    }

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
                        jobFormCreation(job);

                    } else if (object instanceof Car) {// Car type object being recieved
                        System.out.println("Car request recieved...");
                        Car car = (Car) object;
                        System.out.println("Object converted to job...");
                        jobFormCreation(car);
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