
/* Project: Vehicular Cloud System
* Class: ownerPage.java 
* Author: Summer Snyder, Antonios Takos, Teuta Elezaj, Christian Felix, Tahir Buksh, Jayden Kuprel
* Date: February 19th, 2023 
* This program creates the owner page, where users who have selected "Owner"
* will be able to enter details and submit their car for use.
*/ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


class ownerWindow extends JFrame implements ActionListener {

// Intializing variables
    JPanel ownerPage;
    JLabel ownerID, make, model, licensePlate;
    final JTextField ownerIDText, makeText, modelText, licensePlateText;
    JButton submit;

// ---------------------------------------------------------------------------------
// This method creates the GUI for the ownerWindow
    ownerWindow() {
// Assigning variables values
        ownerID = new JLabel();
        ownerID.setText("Owner ID");
        ownerIDText = new JTextField(15);
        make = new JLabel();
        make.setText("Make");
        makeText = new JTextField(15);
        model = new JLabel();
        model.setText("Model");
        modelText = new JTextField(15);
        licensePlate = new JLabel();
        licensePlate.setText("License Plate");
        licensePlateText = new JTextField(15);
        submit = new JButton("Submit");

    // Creating new panel
        ownerPage = new JPanel(new GridLayout(15, 1));
        JLabel welcome = new JLabel("Welcome to the owner page. Please enter the following information, leaving no fields blank.");
        
    // Adding variables to panel
        ownerPage.add(welcome);
        ownerPage.add(ownerID);
        ownerPage.add(ownerIDText);
        ownerPage.add(make);
        ownerPage.add(makeText);
        ownerPage.add(model);
        ownerPage.add(modelText);
        ownerPage.add(licensePlate);
        ownerPage.add(licensePlateText);
        ownerPage.add(submit);
        add(ownerPage, BorderLayout.CENTER);
        // creating action listener for the submit button
        submit.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Car Submission");
        setSize(1000,3000);  
    } // <--- ownerPage() constructor ends here

// ---------------------------------------------------------------------------------
// Creating action listener method
public void actionPerformed(ActionEvent e) {
    // store user input as string variables
    String ownerIDInfo = ownerIDText.getText();
    String ownerMake = makeText.getText();
    String ownerModel = modelText.getText();
    String ownerLicensePlate = licensePlateText.getText();

    // get the current timestamp when the user submits this form
    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    // write the user-provided credentials and timestamp to a file called userInfo.txt, making it so that this information is not overwritten when the program terminates and it is stored in a new line with each submission
    try {
        FileWriter writer = new FileWriter("ownerInfo.txt", true); // true parameter to append to file
        
        writer.write(ownerIDInfo + ":" + ownerMake + ":" + ownerModel + ":" + ownerLicensePlate + ":" + timestamp + "\n");
        writer.close();
        System.out.println("User info successfully saved to file!");

        // success message
        System.out.println("Thank you. Your car has been submitted.");
    } 
    // error message
    catch (IOException ex) {
        System.out.println("Error writing user info to file.");
    }
} // <--- actionPerformed() method ends here
} // <--- ownerWindow{} class ends here

class ownerPage {
    public static void main(String[] args) {
        try {
            ownerWindow form = new ownerWindow();
            form.setSize(300,100);
            form.setVisible(true);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    } // <--- main() method ends here
} // <--- ownerPage{} class ends here