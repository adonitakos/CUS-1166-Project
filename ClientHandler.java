import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class ClientHandler extends Thread {
    final DataInputStream inputStream;
    final DataOutputStream outputStream;
    final Socket socket;

    // Constructor
    public ClientHandler(Socket socket, DataInputStream inputStream, DataOutputStream outputStream) 
    {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    } // <--- ClientHandler() constructor ends here

    public void run() {
        String received;

        while(true) {
            try {
                // Receive the answer from client
                received = inputStream.readUTF();

            } catch (Exception e) {
                e.printStackTrace();
            }

        // Closing resources
            try {
                this.inputStream.close();
                this.outputStream.close();
            } catch(IOException e){
                e.printStackTrace();
            }

        } // <--- while(true) loop ends here
       
    } // <--- run() method ends here

    
} // <--- ClientHandler{} class ends here
