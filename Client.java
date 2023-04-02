import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class Client {
	
	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;

	public void connectClient() {
		try {
			System.out.println("----------*** This is Client side ***--------");
			System.out.println("Client session started!");

			// Connect the client socket to server
			Socket socket = new Socket("localhost", 9806);
			// Client reads a message from Server
			inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new DataOutputStream(socket.getOutputStream());
			socket.close();
		} catch (Exception e) {
			System.out.println("ERROR. Unable to connect!");
			System.out.println(e.getLocalizedMessage());
		}
	} // <--- connectClient() method ends here

	public void openChat() {
		
		String messageIn = "";
		String messageOut = "";
		Scanner keyInput;
		
		try {

			// client reads a message from keyboard
			System.out.println("Enter a message you want to send to server side: ");
			keyInput = new Scanner(System.in);
			messageOut = keyInput.nextLine();
			// server sends the message to client
			outputStream.writeUTF(messageOut);
			
	
			while(!messageIn.equals("exit")) {
				messageIn = inputStream.readUTF();
				// client prints the message received from server to console
				System.out.println("Message received from server: " + "\"" + messageIn + "\"");
				
				
				// ********************************************************
				// client reads a message from keyboard
				System.out.println("Enter a message you want to send to server side: ");
				keyInput = new Scanner(System.in);
				messageOut = keyInput.nextLine();
				// server sends the message to client
				outputStream.writeUTF(messageOut);
				
			} // <--- while(!messageIn) ends here
						
		} catch (Exception e) {
			
			e.printStackTrace();

		} // <--- catch(Exception e) block ends here

	} // <--- openChat() method ends here

} // <--- Client{} class ends here