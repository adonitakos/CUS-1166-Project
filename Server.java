import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;

	public void runServer() {
		try {
			System.out.println("----------$$$ This is server side $$$--------");
			System.out.println("wating for client to connect...");
			// Creating the server
			serverSocket = new ServerSocket(9806);
			// Server accepts connection request from Client
			socket = serverSocket.accept();
			System.out.println("Client is connected!");
			// System.out.println("go to Client side and send me a message");

			// Server reads a message message from Client
			inputStream = new DataInputStream(socket.getInputStream());

			// Server sends a message to Client
			outputStream = new DataOutputStream(socket.getOutputStream());
		}
		catch(Exception e){
			System.out.println("ERROR. Unable to run server");
			System.out.println(e.getMessage());
		}
	} // <--- runServer() method ends here

	// public static void main(String[] args) {
	public void openChat() {
		String messageIn = "";
		String messageOut = "";
		Scanner keyInput;

		try {

			

			// as long as message is not exit keep reading and sending message to client
			while (!messageIn.equals("exit")) {

				// extract the message from client
				messageIn = inputStream.readUTF();
				// server prints the message received from client to console
				System.out.println("message received from client: " + "\"" + messageIn + "\"");

				// ********************************************************
				// server reads a message from keyboard
				System.out.println("Enter a message you want to send to client side: ");
				keyInput = new Scanner(System.in);
				messageOut = keyInput.nextLine();
				// server sends the message to client
				outputStream.writeUTF(messageOut);
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	} // <--- run() method ends here

} // <--- Server{} class ends here