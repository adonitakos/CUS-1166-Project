
/* Project: Vehicle Vortex
* Class: ClientPage.java
* Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
* Date: February 19th, 2023 
* This program creates a client page, where users who have selected "Job" will
* be able to enter details and submit the job they would like completed.
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

class ClientWindow extends JFrame implements ActionListener {
    // Initializing variables
    JLabel clientID, duration, deadline, description;
    final JTextField clientIDText, durationText, deadlineText, descriptionText;
    JButton submit;
    JPanel clientPage;

// ---------------------------------------------------------------------------------
// This method creates the GUI for the ClientWindow
    ClientWindow() {
        // Assigning variables values
        clientID = new JLabel();
        clientID.setText("Client ID:");
        clientIDText = new JTextField(15);
        duration = new JLabel();
        duration.setText("Job Duration:");
        durationText = new JTextField(15);
        deadline = new JLabel();
        deadline.setText("Job Deadline:");
        deadlineText = new JTextField(15);
        description = new JLabel();
        description.setText("Please describe the job:");
        descriptionText = new JTextField(15);
        submit = new JButton("Submit");

        // Creating a new panel
        clientPage = new JPanel(new GridLayout(5, 2));
        JLabel welcome = new JLabel("Welcome to the client page. Please enter the following information, leaving no fields blank.");

        // Adding variables to the panel
        clientPage.add(welcome);
        clientPage.add(new JLabel(""));
        clientPage.add(clientID);
        clientPage.add(clientIDText);
        clientPage.add(duration);
        clientPage.add(durationText);
        clientPage.add(deadline);
        clientPage.add(deadlineText);
        clientPage.add(description);
        clientPage.add(descriptionText);

        add(clientPage, BorderLayout.CENTER);

        // Adding submit button to the panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submit);
        add(buttonPanel, BorderLayout.SOUTH);

        // Creating action listener for the submit button
        submit.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Job Submission");
        setSize(400, 250);   
    } // <--- ClientWindow() constructor ends here

// ---------------------------------------------------------------------------------
    // Action Listener method
    public void actionPerformed(ActionEvent e) {
        // Assigning the information that will be inputted by the user as string variables
        String clientIDInfo = clientIDText.getText();
        String clientDuration = durationText.getText();
        String clientDeadline = deadlineText.getText();
        String clientDescription = descriptionText.getText();

        // getting current timestamp of when user submits form
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // write user inputted credentials and timestamp to a text file called clientInfo.txt
        try {
            FileWriter writer = new FileWriter("clientInfo.txt", true); // true parameter to append to file
            
            writer.write(clientIDInfo + ":" + clientDuration + ":" + clientDeadline + ":" + clientDescription + ":" + timestamp + "\n");
            writer.close();
            System.out.println("Client info successfully saved to file!");

            // confirmation message if successful
            System.out.println("Thank you. Your job has been submitted.");
        } 
        // or error message if unsuccessful
        catch (IOException ex) {
            System.out.println("Error writing client info to file.");
        }
    } // <--- actionPerformed() method ends here
} // <--- clientWindow{} class ends here

class ClientPage {
    public static void main(String[] args) {
        try {
            ClientWindow form = new ClientWindow();
            form.setVisible(true);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here
} // <--- clientPage{} class ends here